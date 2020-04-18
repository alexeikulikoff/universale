package el.controllere.universale.dto;

import java.time.LocalDate;

public class Dto3 implements UDto {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private Long salary;

	public Dto3(String firstName, String lastName, LocalDate birthday, Long salary) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Dto3 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", salary=" + salary + "]";
	}

}
