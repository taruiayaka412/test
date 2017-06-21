package ebook;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BOOK_ORDER database table.
 * 
 */
@Entity
@Table(name="BOOK_ORDER")
@NamedQuery(name="BookOrder.findAll", query="SELECT b FROM BookOrder b")
public class BookOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_number")
	private int orderNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="email")
	private Account account;

	//bi-directional one-to-one association to OrderDetail
	@OneToOne(mappedBy="bookOrder")
	private OrderDetail orderDetail;

	public BookOrder() {
	}

	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public OrderDetail getOrderDetail() {
		return this.orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

}