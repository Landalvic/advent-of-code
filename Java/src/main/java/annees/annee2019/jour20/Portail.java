package annees.annee2019.jour20;

import java.util.ArrayList;
import java.util.List;

public class Portail {

	private String id1;
	private String id2;
	private List<Case> casesPortail = new ArrayList<Case>();
	private List<Case> casesAdjacentes = new ArrayList<Case>();
	private boolean interieur;

	public Portail(String id1) {
		super();
		this.id1 = id1;
	}

	public boolean isInterieur(Case adj) {
		if (adj == casesAdjacentes.get(0)) {
			return interieur;
		} else {
			return !interieur;
		}
	}

	public void setInterieur(boolean interieur) {
		this.interieur = interieur;
	}

	public String getId() {
		if (id1.compareTo(id2) > 0) {
			return id1 + id2;
		} else {
			return id1 + id2;
		}
	}

	public List<Case> getCasesPortail() {
		return casesPortail;
	}

	public void setCasesPortail(List<Case> casesPortail) {
		this.casesPortail = casesPortail;
	}

	public List<Case> getCasesAdjacentes() {
		return casesAdjacentes;
	}

	public void setCasesAdjacentes(List<Case> casesAdjacentes) {
		this.casesAdjacentes = casesAdjacentes;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	@Override
	public String toString() {
		return getId();
	}

}
