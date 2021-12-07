package annees.annee2021.jour07;

public class Annee2021Jour7Exercice2 extends Annee2021Jour7 {

	public static void main(String[] args) {
		new Annee2021Jour7Exercice2().lancer(true);
	}

	public Annee2021Jour7Exercice2() {
		super(2);
	}

	protected int fonction(int x) {
		return x * (x + 1) / 2;
	}

}
