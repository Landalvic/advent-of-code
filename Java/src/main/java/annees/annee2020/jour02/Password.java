package annees.annee2020.jour02;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^(.*)-(.*) (.*): (.*)$")
public class Password {

	@PatternAttribute(1)
	private Integer nbrMin;
	@PatternAttribute(2)
	private Integer nbrMax;
	@PatternAttribute(3)
	private String lettre;
	@PatternAttribute(4)
	private String motDePasse;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNbrMin() {
		return nbrMin;
	}

	public void setNbrMin(int nbrMin) {
		this.nbrMin = nbrMin;
	}

	public int getNbrMax() {
		return nbrMax;
	}

	public void setNbrMax(int nbrMax) {
		this.nbrMax = nbrMax;
	}

	public String getLettre() {
		return lettre;
	}

	public void setLettre(String lettre) {
		this.lettre = lettre;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Password [nbrMin=" + nbrMin + ", nbrMax=" + nbrMax + ", lettre=" + lettre + ", motDePasse=" + motDePasse + ", count=" + count + "]";
	}

}
