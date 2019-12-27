package annees.annee2019.jour22;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour22Exercice2 extends Exercice {

	protected static final Pattern pattern1 = Pattern.compile("deal with increment (.*)");
	protected static final Pattern pattern2 = Pattern.compile("deal into new stack");
	protected static final Pattern pattern3 = Pattern.compile("cut (.*)");

	public static void main(String[] args) {
		new Annee2019Jour22Exercice2().lancer("src/main/resources/annee2019/jour22/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		long taille = 119315717514047L;
		long monNombre = 2020L;
		long nbrFois = 101741582076661L;
		long maxNbrFois = 10000000L;
		List<Operation> operations = new ArrayList<Operation>();
		for (String string : lignes) {
			var matcher = FileUtils.trouverPatternInt(string, pattern1, 1);
			var matcher2 = FileUtils.trouverPattern(string, pattern2, 0);
			var matcher3 = FileUtils.trouverPatternInt(string, pattern3, 1);
			if (matcher.length > 0) {
				int increment = matcher[0];
				operations.add(new Increment(increment));
			} else if (matcher2.length > 0) {
				operations.add(new NewStack());
			} else if (matcher3.length > 0) {
				long cut = matcher3[0];
				if (cut < 0) {
					cut += taille;
				}
				operations.add(new Cut(cut));
			}
		}
		long differentiel = (operations.get(operations.size() - 1).calcul(operations, operations.size() - 1, taille, 1)
				- operations.get(operations.size() - 1).calcul(operations, operations.size() - 1, taille, 0) + taille)
				% taille;
		long suivant = operations.get(operations.size() - 1).calcul(operations, operations.size() - 1, taille,
				monNombre);
		var paramsMax = parametreDifferentiel(taille, differentiel, maxNbrFois);
		var paramsReste = parametreDifferentiel(taille, differentiel, nbrFois % maxNbrFois);
		long boucle = nbrFois / maxNbrFois;
		System.out.println(boucle * maxNbrFois + (nbrFois % maxNbrFois));
		for (long i = 0; i < boucle; i++) {
			long newSuivant = calculBigInt(suivant, monNombre, paramsMax.getDiff(), taille);
			monNombre = calculBigInt(suivant, monNombre, paramsMax.getDiffMoins1(), taille);
			suivant = newSuivant;
		}
		long newSuivant = calculBigInt(suivant, monNombre, paramsReste.getDiff(), taille);
		monNombre = calculBigInt(suivant, monNombre, paramsReste.getDiffMoins1(), taille);
		suivant = newSuivant;
		System.out.println(monNombre);
		return "";
	}

	public long calculBigInt(long suivant, long monNombre, long multiply, long taille) {
		var suivantBig = new BigInteger("" + suivant);
		var monNombreBig = new BigInteger("" + monNombre);
		var multiplyBig = new BigInteger("" + multiply);
		var tailleBig = new BigInteger("" + taille);
		return suivantBig.add(monNombreBig.negate()).multiply(multiplyBig).add(suivantBig).mod(tailleBig).longValue();
	}

	public ParametreDifferentiel parametreDifferentiel(long taille, long differentiel, long tailleDiff)
			throws AdventOfCodeException {
		var differentielBig = new BigInteger("" + differentiel);
		var tailleBig = new BigInteger("" + taille);
		long a = 0;
		long oldA = 0;
		for (long i = 0; i < tailleDiff; i++) {
			oldA = a;
			var aBig = new BigInteger("" + (a + 1));
			a = differentielBig.multiply(aBig).mod(tailleBig).longValue();
		}
		return new ParametreDifferentiel(a, oldA);
	}

}
