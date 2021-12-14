package annees.annee2021.jour12;

import commun.Infos;

public class Grotte extends Infos {

	private static final long serialVersionUID = 1L;

	private boolean grande;

	public Grotte(String id) {
		super(id);
		grande = Character.isUpperCase(id.charAt(0));
	}

	public boolean isGrande() {
		return grande;
	}

	public void setGrande(boolean grande) {
		this.grande = grande;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
