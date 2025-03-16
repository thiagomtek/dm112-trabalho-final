package br.inatel.dm112.interfaces;

import br.inatel.dm112.model.DeliveryStatus;

public interface Delivery {

	DeliveryStatus confirmDeliverytOfOrder(String cpf, int orderNumber);

}