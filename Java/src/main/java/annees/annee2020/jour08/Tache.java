package annees.annee2020.jour08;

import commun.annotation.PatternAttribute;

public abstract class Tache {

	@PatternAttribute(1)
	private Integer nbr;
	private boolean runned;

	protected Tache() {
		super();
		runned = false;
	}

	public boolean isRunned() {
		return runned;
	}

	public void setRunned(boolean runned) {
		this.runned = runned;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public abstract void run(Donnees donnees);

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [nbr=" + nbr + ", runned=" + runned + "]";
	}

}
