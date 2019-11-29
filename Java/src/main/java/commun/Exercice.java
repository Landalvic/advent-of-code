package commun;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Exercice {

	protected static final Logger logger = LoggerFactory.getLogger(Exercice.class);
	protected static final String AUCUNE_SOLUTION = "Aucune solution";
	protected long debut;

	public Exercice() {
		super();
		this.debut = System.currentTimeMillis();
	}

	protected abstract String run(String input) throws AdventOfCodeException;

	protected void lancer(String input) {
		try {
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
