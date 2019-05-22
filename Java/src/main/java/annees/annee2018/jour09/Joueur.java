package annees.annee2018.jour09;

public class Joueur {

	private long score;

	public Joueur() {
		super();
		score = 0;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public void addScore(long score) {
		this.score += score;
	}

	@Override
	public String toString() {
		return "Joueur [score=" + score + "]";
	}

}
