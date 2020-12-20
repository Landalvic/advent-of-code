package annees.annee2020.jour13;

public class Bus {

	private long id;
	private long decalage;

	public Bus(long id, long decalage) {
		super();
		this.id = id;
		this.decalage = decalage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDecalage() {
		return decalage;
	}

	public void setDecalage(long decalage) {
		this.decalage = decalage;
	}

}
