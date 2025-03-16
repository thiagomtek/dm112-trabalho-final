package br.inatel.dm112.model;

public class MailRequestData {

	private int orderNumber;
	private String to;

	public MailRequestData() {
	}

	public MailRequestData(int orderNumber, String to) {
		this.orderNumber = orderNumber;
		this.to = to;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public String getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "MailRequestData [orderNumber=" + orderNumber + ", to=" + to + "]";
	}

}
