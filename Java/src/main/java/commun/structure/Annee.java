package commun.structure;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Annee {

	protected static final Logger logger = LoggerFactory.getLogger(Annee.class);
	protected long debut;
	protected List<Exercice> exercices;

	protected Annee() {
		super();
		this.exercices = new ArrayList<>();
		this.debut = System.currentTimeMillis();
	}

	public long getDebut() {
		return debut;
	}

	public void setDebut(long debut) {
		this.debut = debut;
	}

	public List<Exercice> getExercices() {
		return exercices;
	}

	public void setExercices(List<Exercice> exercices) {
		this.exercices = exercices;
	}

	protected void lancer() {
		for (Exercice exercice : exercices) {
			exercice.lancer(false, false);
		}
		long fin = System.currentTimeMillis();
		logger.info("********** Le batch se termine **********");
		var calcul = DurationFormatUtils.formatDuration(fin - debut, "HH:mm:ss:SSS", true);
		logger.info("Le batch a duré : {}", calcul);
	}

}
