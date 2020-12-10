package annees.annee2015.jour13;

import commun.structure.AdventOfCodeException;

public class Annee2015Jour13Exercice2 extends Annee2015Jour13 {

	public static void main(String[] args) {
		new Annee2015Jour13Exercice2().lancer("src/main/resources/annee2015/jour13/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		inputToInvites(input);
		Personne vous = new Personne("Vous");
		for (Personne personne : invites.values()) {
			vous.getAmities().put(personne, 0);
			personne.getAmities().put(vous, 0);
		}
		invites.put("Vous", vous);
		return bonheurMax();
	}

}
