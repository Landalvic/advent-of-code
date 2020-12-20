package annees.annee2020.jour02;

import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.util.StreamUtils;

public class Annee2020Jour2Exercice2 extends Annee2020Jour2 {

	public static void main(String[] args) {
		new Annee2020Jour2Exercice2().lancer(true);
	}

	public Annee2020Jour2Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<Password> passwords = inputToStreamObject(input);
		return String.valueOf(passwords.filter(password -> {
			boolean test1 = StreamUtils.charEquals(password.getMotDePasse().charAt(password.getNbrMin() - 1), password.getLettre());
			boolean test2 = StreamUtils.charEquals(password.getMotDePasse().charAt(password.getNbrMax() - 1), password.getLettre());
			return test1 ^ test2;
		}).count());
	}

}
