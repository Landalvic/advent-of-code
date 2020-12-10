package annees.annee2020.jour08;

import commun.annotation.PatternAttribute;

public abstract class Tache {

	@PatternAttribute(1)
	private Integer nbr;
	private boolean test;

	public Tache() {
		super();
		test = false;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public abstract void run(Donnees donnees);

}
