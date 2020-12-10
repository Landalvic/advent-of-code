package commun.structure;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import commun.util.FileUtils;

public abstract class Exercice {

	protected static final Logger logger = LoggerFactory.getLogger(Exercice.class);
	protected long debut;
	protected boolean test;

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

	public Exercice() {
		super();
		this.debut = System.currentTimeMillis();
		test = false;
	}

	protected void init() {
	}

	protected abstract String run(String input) throws AdventOfCodeException;

	protected void lancer(int annee, int jour, int exercice, boolean test) {
		this.test = test;
		String jourStr = String.valueOf(jour);
		if (jourStr.length() == 1) {
			jourStr = "0" + jourStr;
		}
		String racine = "src/main/resources/annee" + annee + "/jour" + jourStr;
		if (test) {
			int numeroTest = 1;
			String input = racine + "/test" + exercice + "-" + numeroTest + ".txt";
			while (FileUtils.exist(input)) {
				tester(input, numeroTest);
				numeroTest++;
				input = racine + "/test" + exercice + "-" + numeroTest + ".txt";
			}
		}
		this.test = false;
		String input = racine + "/data.txt";
		lancer(input);
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

	protected void lancer(String input) {
		try {
			init();
			var reponse = run(input);
			logger.info("{}", reponse);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		long fin = System.currentTimeMillis();
		logger.info("********** Le batch se termine **********");
		var calcul = DurationFormatUtils.formatDuration(fin - debut, "HH:mm:ss:SSS", true);
		logger.info("Le batch a duré : {}", calcul);
	}

}
