package annees.annee2021.jour03;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.Position;
import commun.StreamBuilder;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;
import commun.util.MathUtils;

public class Annee2021Jour3Exercice2 extends Annee2021Jour3 {

	public static void main(String[] args) {
		new Annee2021Jour3Exercice2().lancer(true);
	}

	public Annee2021Jour3Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var liste = FileUtils.listOfStreamBuilder(input);
		var gamma = calcul(liste, 0, "1", "0");
		var epsilon = calcul(liste, 0, "0", "1");
		return String.valueOf(gamma * epsilon);
	}

	private long calcul(List<StreamBuilder> liste, int index, String charPrincipal, String charAEnlever) {
		if (liste.size() == 1) {
			return MathUtils.binaryToLong(liste.get(0).toString(), 2);
		}
		var position = new Position(0, 0);
		liste.forEach(list -> updatePosition(list.charAt(index), position));
		String charAVerifier = position.getX() >= position.getY() ? charPrincipal : charAEnlever;
		List<StreamBuilder> newListe = liste.stream().filter(s -> StringUtils.equals(s.charAt(index), charAVerifier)).toList();
		return calcul(newListe, index + 1, charPrincipal, charAEnlever);
	}

}
