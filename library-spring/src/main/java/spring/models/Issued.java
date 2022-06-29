package spring.models;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Issued {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
	private Book book;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id")
	private Reader reader;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empl_id")
	private Employee employee;

	@Column(name = "date_iss")
	private Date dateIss;

	@Column(name = "date_return")
	private Date dateReturn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDateIss() {
		return dateIss;
	}

	public void setDateIss(Date date_iss) {
		this.dateIss = date_iss;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date date_return) {
		this.dateReturn = date_return;
	}

	@Override
	public String toString() {
		return "Issued [id=" + id + ", book=" + book + ", reader=" + reader + ", employee=" + employee + ", date_iss="
				+ dateIss + ", date_return=" + dateReturn + "]";
	}

}
