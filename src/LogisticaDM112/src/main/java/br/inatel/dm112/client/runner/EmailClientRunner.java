package br.inatel.dm112.client.runner;

import br.inatel.dm112.client.EmailClient;

public class EmailClientRunner {

	public static void main(String[] args) {
		EmailClient client = new EmailClient();
		client.setRestURL(ClientUtil.getUtilityRestEmailURL());
		client.setSendToAddress(ClientUtil.getEmailSendToAddress());

		int orderNumber = 5555; // any test order number
		client.callSendMailService(orderNumber);
		System.out.println("Sucesso na chamada para envio do email.");
	}
}
