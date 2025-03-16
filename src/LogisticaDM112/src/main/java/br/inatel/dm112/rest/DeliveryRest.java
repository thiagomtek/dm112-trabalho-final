package br.inatel.dm112.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.dm112.interfaces.Delivery;
import br.inatel.dm112.model.DeliveryStatus;
import br.inatel.dm112.services.DeliveryService;

@RestController
@RequestMapping("/api")
public class DeliveryRest implements Delivery {

	@Autowired
	private DeliveryService service;

	@Override
	@GetMapping("/confirmDeliverytOfOrder/{cpf:.+}/{orderNumber}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public DeliveryStatus confirmDeliverytOfOrder(
			@PathVariable("cpf") String cpf, 
			@PathVariable("orderNumber") int orderNumber) {
		
		System.out.println("DeliveryRest - confirmDeliverytOfOrder");
		return service.confirmDeliveryOfOrder(cpf, orderNumber);
	}

}