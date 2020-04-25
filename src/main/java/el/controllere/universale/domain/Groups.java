package el.controllere.universale.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "groups")
public class Groups implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p")
	private Long p;
	private String name;
	private String code;
	private Long q;

	public Groups() {
	}

	public Groups(Long p, String name, String code, Long q) {
		super();
		this.p = p;
		this.name = name;
		this.code = code;
		this.q = q;
	}

	public Long getP() {
		return p;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public Long getQ() {
		return q;
	}

}
