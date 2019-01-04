package commun;

import org.apache.commons.lang3.time.DurationFormatUtils;

public abstract class Exercice implements Runnable {

	private long debut;

	public Exercice() {
		super();
		this.debut = System.currentTimeMillis();
		lancer();
	}

	private void lancer() {
		run();
		long fin = System.currentTimeMillis();
		System.out.println("********** Le batch se termine **********");
		System.out
				.println("Le batch a duré : " + DurationFormatUtils.formatDuration(fin - debut, "HH:mm:ss:SSS", true));
	}

}
