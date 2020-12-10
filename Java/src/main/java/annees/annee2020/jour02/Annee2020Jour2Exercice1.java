package annees.annee2020.jour02;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.util.StreamUtils;

public class Annee2020Jour2Exercice1 extends Annee2020Jour2 {

	public static void main(String[] args) {
		new Annee2020Jour2Exercice1().lancer(2020, 2, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<Password> passwords = inputToStreamObject(input);
		return String.valueOf(passwords.filter(password -> {
			long count = StreamUtils.chars(password.getMotDePasse())
					.filter(lettre -> StringUtils.equals(lettre, password.getLettre())).count();
			return count >= password.getNbrMin() && count <= password.getNbrMax();
		}).count());
	}

}
