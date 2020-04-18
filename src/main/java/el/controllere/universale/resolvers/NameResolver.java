package el.controllere.universale.resolvers;

public class NameResolver {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UResponse [name=" + name + "]";
	}

}
