package annees.annee2018.jour03;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import commun.Exercice;
import util.FileUtils;

public abstract class Annee2018Jour3 extends Exercice {

	protected static final Pattern distanceGauchePattern = Pattern.compile(".* @ (.*),.*");
	protected static final Pattern distanceHautPattern = Pattern.compile(".*,(.*): .*");
	protected static final Pattern largeurPattern = Pattern.compile(".*: (.*)x.*");
	protected static final Pattern hauteurPattern = Pattern.compile(".*x(.*)");
	protected static final Pattern idPattern = Pattern.compile("#(.*) @ .*");
	protected AtomicInteger[][] tissu = new AtomicInteger[1000][1000];

	public Annee2018Jour3() {
		super();
		tissu = new AtomicInteger[1000][1000];
	}

	protected List<Demande> inputToDemandes(String input) {
		Stream<String> liste = FileUtils.streamOfLines(input);
		return liste.map(string -> toDemande(string)).collect(toList());
	}

	protected Demande toDemande(String string) {
		int distanceGauche = FileUtils.trouverPatternInt(string, distanceGauchePattern);
		int distanceHaut = FileUtils.trouverPatternInt(string, distanceHautPattern);
		int largeur = FileUtils.trouverPatternInt(string, largeurPattern);
		int hauteur = FileUtils.trouverPatternInt(string, hauteurPattern);
		int id = FileUtils.trouverPatternInt(string, idPattern);
		Demande demande = new Demande(id);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				AtomicInteger integer = tissu[i + distanceGauche][j + distanceHaut];
				if (integer == null) {
					integer = new AtomicInteger(0);
					tissu[i + distanceGauche][j + distanceHaut] = integer;
				}
				integer.incrementAndGet();
				demande.getMorceaux().add(integer);
			}
		}
		return demande;
	}

}
