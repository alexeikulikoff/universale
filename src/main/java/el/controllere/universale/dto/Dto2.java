package el.controllere.universale.dto;

import java.time.LocalDate;

public class Dto2 implements UDto {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;

	public Dto2(String firstName, String lastName, LocalDate birthday) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
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

	@Override
	public String toString() {
		return "Dto2 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ "]";
	}

}
