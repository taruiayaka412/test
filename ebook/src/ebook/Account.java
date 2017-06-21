package ebook;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String password;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-many association to Book
	@ManyToMany(mappedBy="accounts")
	private List<Book> books;

	//bi-directional many-to-one association to BookOrder
	@OneToMany(mappedBy="account")
	private List<BookOrder> bookOrders;

	public Account() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<BookOrder> getBookOrders() {
		return this.bookOrders;
	}

	public void setBookOrders(List<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}

	public BookOrder addBookOrder(BookOrder bookOrder) {
		getBookOrders().add(bookOrder);
		bookOrder.setAccount(this);

		return bookOrder;
	}

	public BookOrder removeBookOrder(BookOrder bookOrder) {
		getBookOrders().remove(bookOrder);
		bookOrder.setAccount(null);

		return bookOrder;
	}

}