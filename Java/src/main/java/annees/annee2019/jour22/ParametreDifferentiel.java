package annees.annee2019.jour22;

public class ParametreDifferentiel {

	private long diff;
	private long diffMoins1;

	public ParametreDifferentiel(long diff, long diffMoins1) {
		super();
		this.diff = diff;
		this.diffMoins1 = diffMoins1;
	}

	public long getDiff() {
		return diff;
	}

	public void setDiff(long diff) {
		this.diff = diff;
	}

	public long getDiffMoins1() {
		return diffMoins1;
	}

	public void setDiffMoins1(long diffMoins1) {
		this.diffMoins1 = diffMoins1;
	}

}
