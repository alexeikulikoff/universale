package el.controllere.universale.dto;

public class Dto1 implements RootDto {

	private Long id;
	private String firstName;
	private String lastName;

	public Dto1(String firstName, String lastName) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
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

}
