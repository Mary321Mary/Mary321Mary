package spring.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
	
	private String fio;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
	private List<Position> position;

	@Column(name = "hiring_date")
	private Date hiringDate;

	@Column(name = "dismissal_date")
	private Date dismissalDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFio() {
		return fio;
	}
	
	public void setFio(String fio) {
		this.fio = fio;
	}
	
	public List<Position> getPosition() {
		return position;
	}
	
	public void setPosition(List<Position> position) {
		this.position = position;
	}
	
	public Date getHiringDate() {
		return hiringDate;
	}
	
	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
	
	public Date getDismissalDate() {
		return dismissalDate;
	}
	
	public void setDismissalDate(Date dismissalDate) {
		this.dismissalDate = dismissalDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fio=" + fio + ", hiringDate=" + hiringDate + ", dismissalDate=" + dismissalDate
				+ "]";
	}
	
}
