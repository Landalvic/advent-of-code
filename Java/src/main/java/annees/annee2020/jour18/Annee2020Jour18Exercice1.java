package annees.annee2020.jour18;

import java.util.Arrays;
import java.util.stream.Stream;

import commun.calculatrice.Calculatrice;
import commun.calculatrice.OperateurAddition;
import commun.calculatrice.OperateurMultiplication;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour18Exercice1 extends Annee2020Jour18 {

	public static void main(String[] args) {
		new Annee2020Jour18Exercice1().lancer(true);
	}

	public Annee2020Jour18Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> lignes = FileUtils.streamOfLines(input);
		Calculatrice calculatrice = new Calculatrice(Arrays.asList(new OperateurAddition(1), new OperateurMultiplication(1)));
		return String.valueOf((long) lignes.mapToDouble(calculatrice::calcul).sum());
	}
}
