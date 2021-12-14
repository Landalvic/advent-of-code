package commun.structure;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import commun.util.FileUtils;

public abstract class Exercice {

	protected static final Logger logger = LoggerFactory.getLogger(Exercice.class);
	protected long debut;
	protected boolean test;
	protected int annee;
	protected int jour;
	protected int numeroExercice;

	protected Exercice(int annee, int jour, int numeroExercice) {
		super();
		this.annee = annee;
		this.jour = jour;
		this.numeroExercice = numeroExercice;
		this.debut = System.currentTimeMillis();
		test = false;
	}

	public long getDebut() {
		return debut;
	}

	public void setDebut(long debut) {
		this.debut = debut;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	protected void init() {}

	protected abstract String run(String input) throws AdventOfCodeException;

	public String lancer() {
		return lancer(false);
	}

	public String lancer(boolean test) {
		return lancer(test, true);
	}

	public String lancer(boolean test, boolean timer) {
		this.test = test;
		String jourStr = String.valueOf(jour);
		if (jourStr.length() == 1) {
			jourStr = "0" + jourStr;
		}
		String racine = "src/main/resources/annee" + annee + "/jour" + jourStr;
		if (test) {
			int numeroTest = 1;
			String input = racine + "/test" + numeroExercice + "-" + numeroTest + ".txt";
			while (FileUtils.exist(input)) {
				tester(input, numeroTest);
				numeroTest++;
				input = racine + "/test" + numeroExercice + "-" + numeroTest + ".txt";
			}
		}
		this.test = false;
		String input = racine + "/data.txt";
		return lancer(input, timer);
	}

	protected void tester(String input, int numero) {
		try {
			init();
			var reponse = run(input);
			logger.info("Test n°{} : {}", numero, reponse);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	protected String lancer(String input) {
		return lancer(input, true);
	}

	protected String lancer(String input, boolean timer) {
		String reponse = null;
		try {
			init();
			reponse = run(input);
			logger.info("Année {} / Jour {} / Exercice {} : {}", annee, jour, numeroExercice, reponse);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (timer) {
			long fin = System.currentTimeMillis();
			logger.info("********** Le batch se termine **********");
			var calcul = DurationFormatUtils.formatDuration(fin - debut, "HH:mm:ss:SSS", true);
			logger.info("Le batch a duré : {}", calcul);
		}
		return reponse;
	}

}
