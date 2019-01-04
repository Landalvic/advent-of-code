package annee.annee2018.jour18;

import java.util.ArrayList;
import java.util.List;

public class Acre {

	private Type type;
	private Type typeSauvegarde;
	private List<Acre> acresAdjacentes;

	public Acre(Type type) {
		super();
		this.type = type;
		acresAdjacentes = new ArrayList<>();
	}

	public Type getTypeSauvegarde() {
		return typeSauvegarde;
	}

	public void setTypeSauvegarde(Type typeSauvegarde) {
		this.typeSauvegarde = typeSauvegarde;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Acre> getAcresAdjacentes() {
		return acresAdjacentes;
	}

	public void setAcresAdjacentes(List<Acre> acresAdjacentes) {
		this.acresAdjacentes = acresAdjacentes;
	}

	@Override
	public String toString() {
		switch (type) {
		case OUVERT:
			return ".";
		case ARBRE:
			return "|";
		case COURS_A_BOIS:
			return "#";
		default:
			return "";
		}
	}

}
