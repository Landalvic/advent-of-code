package commun;

import java.io.Serializable;
import java.util.Objects;

public class Infos implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;

	public Infos() {
		super();
	}

	public Infos(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Infos [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Infos other = (Infos) obj;
		return Objects.equals(id, other.id);
	}

}
