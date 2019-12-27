package annees.annee2019.jour04;

public class Annee2019Jour4Exercice1 extends Annee2019Jour4 {

	public static void main(String[] args) {
		new Annee2019Jour4Exercice1().lancer(2019, 4, 1, false);
	}

	protected boolean respectCritere(int mdp) {
		String s = String.valueOf(mdp);
		int oldDigit = 0;
		boolean ok = true;
		boolean doubl = false;
		for (int j = 0; j < s.length(); j++) {
			int digit = Integer.parseInt(String.valueOf(s.charAt(j)));
			if (digit < oldDigit) {
				ok = false;
				break;
			}
			if (digit == oldDigit) {
				doubl = true;
			}
			oldDigit = digit;
		}
		return ok && doubl;
	}

}
