package annees.annee2020.jour17;

public class Annee2020Jour17Exercice1 extends Annee2020Jour17 {

	public static void main(String[] args) {
		new Annee2020Jour17Exercice1().lancer(true);
	}

	public Annee2020Jour17Exercice1() {
		super(1);
	}

	@Override
	protected void init() {
		dimension = 3;
	}
}
