package annees.annee2018.jour15;

import java.util.ArrayList;
import java.util.List;

public class Case implements Comparable<Case> {

	private int positionX;
	private int positionY;
	private boolean mur;
	private Personnage personnage;
	private List<Case> casesAdjacentes;

	public Case(int positionX, int positionY, boolean mur) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.mur = mur;
		casesAdjacentes = new ArrayList<>(4);
	}

	public int distance(Case case1) {
		return Math.abs(positionX - case1.positionX) + Math.abs(positionY - case1.positionY);
	}

	public List<Case> getCasesAdjacentes() {
		return casesAdjacentes;
	}

	public void setCasesAdjacentes(List<Case> casesAdjacentes) {
		this.casesAdjacentes = casesAdjacentes;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public boolean isMur() {
		return mur;
	}

	public void setMur(boolean mur) {
		this.mur = mur;
	}

	@Override
	public String toString() {
		if (personnage != null) {
			return personnage.toString();
		} else {
			return mur ? "#" : ".";
		}
	}

	@Override
	public int compareTo(Case o) {
		int compareY = Integer.compare(getPositionY(), o.getPositionY());
		if (compareY == 0) {
			return Integer.compare(getPositionX(), o.getPositionX());
		} else {
			return compareY;
		}
	}

}
