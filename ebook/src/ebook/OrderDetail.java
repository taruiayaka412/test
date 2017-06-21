package ebook;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ORDER_DETAIL database table.
 * 
 */
@Entity
@Table(name="ORDER_DETAIL")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_number")
	private int orderNumber;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;

	//bi-directional one-to-one association to BookOrder
	@OneToOne
	@JoinColumn(name="order_number")
	private BookOrder bookOrder;

	public OrderDetail() {
	}

	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookOrder getBookOrder() {
		return this.bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}

}