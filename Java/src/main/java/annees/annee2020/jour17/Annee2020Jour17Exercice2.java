package annees.annee2020.jour17;

public class Annee2020Jour17Exercice2 extends Annee2020Jour17 {

	public static void main(String[] args) {
		new Annee2020Jour17Exercice2().lancer(true);
	}

	public Annee2020Jour17Exercice2() {
		super(2);
	}

	@Override
	protected void init() {
		dimension = 4;
	}

}
