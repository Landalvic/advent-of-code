package annees.annee2020.jour02;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.util.TexteUtils;

public class Annee2020Jour2Exercice1 extends Annee2020Jour2 {

	public static void main(String[] args) {
		new Annee2020Jour2Exercice1().lancer(true);
	}

	public Annee2020Jour2Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<Password> passwords = inputToStreamObject(input);
		var total = passwords.filter(password -> {
			long count = TexteUtils.stringToStream(password.getMotDePasse()).filter(lettre -> StringUtils.equals(lettre, password.getLettre())).count();
			return count >= password.getNbrMin() && count <= password.getNbrMax();
		}).count();
		return String.valueOf(total);
	}

}
