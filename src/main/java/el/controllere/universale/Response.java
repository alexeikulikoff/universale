package el.controllere.universale;

public class Response<T> {

	private String name;
	private String message;

	private T content;

	public Response() {
	}

	public Response(String name, String message, T content) {
		super();
		this.name = name;
		this.message = message;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

}
