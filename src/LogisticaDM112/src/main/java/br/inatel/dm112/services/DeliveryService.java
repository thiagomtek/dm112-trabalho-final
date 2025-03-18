package br.inatel.dm112.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.dm112.client.OrderClient;
import br.inatel.dm112.model.DeliveryStatus;
import br.inatel.dm112.model.DeliveryStatus.DELIVERY_STATUS;
import br.inatel.dm112.model.Order;

@Service
public class DeliveryService {

	@Autowired
	private OrderClient clientOrder;

	/**
	 * Lógica de confirmação do delivery (1) consulta o pedido pelo número (2)
	 * atualiza o status da entrega confirmando (3) responde Ok
	 * 
	 * @param cpf
	 * @param orderNumber
	 * @return
	 */
	public DeliveryStatus confirmDeliveryOfOrder(String cpf, int orderNumber) {

		Order order = getOrder(cpf, orderNumber); // (1) consulta o pedido pelo número

		if (order.getStatus() == Order.STATUS.DELIVERED.ordinal()) {
			String msg = "Status do pedido " + orderNumber + " já entregue: " + order.getStatus();
			throw DeliveryStatus.createErrorStatus(msg, cpf, orderNumber, DELIVERY_STATUS.WRONG_ORDER_STATUS);
		}
		try {
			clientOrder.confirmOrderDelivery(orderNumber, cpf); // (2) confirma o delivery (e atualiza o status)
		} catch (Exception e) {
			String msg = "Erro no serviço de pedido: confirm delivery";
			throw DeliveryStatus.createErrorStatus(msg, cpf, orderNumber, DELIVERY_STATUS.ORDER_ERROR);
		}
		System.out.println("Sucesso ao confirmar a entrega: orderNumber: " + orderNumber + " cpf: " + cpf);
		return new DeliveryStatus(DELIVERY_STATUS.OK.ordinal(), cpf, orderNumber); // (3) responde Ok
	}

	private Order getOrder(String cpf, int orderNumber) {
		if (cpf == null || orderNumber < 0) {
			throw DeliveryStatus.createErrorStatus("CPF e pedido são obrigatórios", cpf, orderNumber,
					DELIVERY_STATUS.NULL_VALUES);
		}
		Order order;
		try {
			order = clientOrder.retrieveOrder(orderNumber); // (1) consulta o pedido pelo número
		} catch (Exception e) {
			String msg = "Pedido " + orderNumber + " não encontrado.";
			throw DeliveryStatus.createErrorStatus(msg, cpf, orderNumber, DELIVERY_STATUS.ORDER_NOT_FOUND);
		}
		return order;
	}

}