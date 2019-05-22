package annees.annee2018.jour06;

public class Emplacement {

	private static int idGenerator = 0;
	private Integer id;
	private Integer idPlusProche;

	public Emplacement() {
		super();
	}

	public void genererId() {
		idGenerator++;
		id = idGenerator;
		idPlusProche = idGenerator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPlusProche() {
		return idPlusProche;
	}

	public void setIdPlusProche(Integer idPlusProche) {
		this.idPlusProche = idPlusProche;
	}

	@Override
	public String toString() {
		if (id == null) {
			return "" + idPlusProche;
		} else {
			return "id=" + idPlusProche;
		}
	}

}
