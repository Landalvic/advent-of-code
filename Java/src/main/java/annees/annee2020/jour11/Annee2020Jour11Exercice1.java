package annees.annee2020.jour11;

public class Annee2020Jour11Exercice1 extends Annee2020Jour11 {

	public static void main(String[] args) {
		new Annee2020Jour11Exercice1().lancer(true);
	}

	public Annee2020Jour11Exercice1() {
		super(1);
	}

	@Override
	protected void gererSiege(Siege siege) {
		var adj = siege.getCasesAdjacentesDiag();
		var testAll = true;
		int occupe = 0;
		for (Siege siegeA : adj) {
			if (siegeA.getOccupe() != null && siegeA.getOccupe().booleanValue()) {
				testAll = false;
				occupe++;
			}
		}
		if (testAll) {
			siege.setFuturePlace(true);
		} else if (occupe >= 4) {
			siege.setFuturePlace(false);
		} else {
			siege.setFuturePlace(null);
		}
	}

}
