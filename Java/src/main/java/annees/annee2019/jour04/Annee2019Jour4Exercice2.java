package annees.annee2019.jour04;

public class Annee2019Jour4Exercice2 extends Annee2019Jour4 {

	public static void main(String[] args) {
		new Annee2019Jour4Exercice2().lancer(true);
	}

	public Annee2019Jour4Exercice2() {
		super(2);
	}

	protected boolean respectCritere(int mdp) {
		String s = String.valueOf(mdp);
		int oldDigit = 0;
		boolean ok = true;
		boolean doubl = false;
		int nbr = 0;
		for (int j = 0; j < s.length(); j++) {
			int digit = Integer.parseInt(String.valueOf(s.charAt(j)));
			if (digit < oldDigit) {
				ok = false;
				break;
			}
			if (digit == oldDigit) {
				nbr++;
			} else {
				if (nbr == 1) {
					doubl = true;
				}
				nbr = 0;
			}
			oldDigit = digit;
		}
		if (nbr == 1) {
			doubl = true;
		}
		return ok && doubl;
	}

}
