package br.inatel.dm112.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.inatel.dm112.model.Order.STATUS;

@Entity
@Table(name = "Pedido")
public class OrderEntity {
	
	@Id
	@Column(name = "numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer number;
	
	@Column(name = "cpf")
	private String CPF;
	
	@Column(name = "recipientsCpf")
	private String recipientsCpf;

	@Column(name = "valor")
	private float value;

	private int status;

	@Column(name = "dataPedido", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@Column(name = "dataEmissao", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date issueDate;

	@Column(name = "dataPagamento", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;
	
	@Column(name = "dataEntrega", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;

	public OrderEntity() {
		this.status = STATUS.FILLED.ordinal();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getRecipientsCpf() {
		return recipientsCpf;
	}

	public void setRecipientsCpf(String recipientsCpf) {
		this.recipientsCpf = recipientsCpf;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "OrderEntity [number=" + number + ", CPF=" + CPF + ", recipientsCpf=" + recipientsCpf + ", value="
				+ value + ", status=" + status + ", orderDate=" + orderDate + ", issueDate=" + issueDate
				+ ", paymentDate=" + paymentDate + ", deliveryDate=" + deliveryDate + "]";
	}

}
