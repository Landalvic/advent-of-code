package annees.annee2021.jour12;

import commun.Infos;

public class InfosChemin extends Infos {

	private static final long serialVersionUID = 1L;

	private boolean contientDouble;

	public InfosChemin(InfosChemin infos) {
		super();
		if (infos == null) {
			contientDouble = false;
		} else {
			contientDouble = infos.contientDouble;
		}
	}

	public boolean isContientDouble() {
		return contientDouble;
	}

	public void setContientDouble(boolean contientDouble) {
		this.contientDouble = contientDouble;
	}

	@Override
	public String toString() {
		return "InfosChemin [contientDouble=" + contientDouble + "]";
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
