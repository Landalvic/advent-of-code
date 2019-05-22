package commun;

import org.apache.commons.lang3.time.DurationFormatUtils;

public abstract class Exercice {

	protected static final String AUCUNE_SOLUTION = "Aucune solution";
	protected long debut;

	public Exercice() {
		super();
		this.debut = System.currentTimeMillis();
	}

	protected abstract String run(String input) throws Exception;

	protected void lancer(String input) {
		try {
			System.out.println(run(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
		long fin = System.currentTimeMillis();
		System.out.println("********** Le batch se termine **********");
		System.out
				.println("Le batch a duré : " + DurationFormatUtils.formatDuration(fin - debut, "HH:mm:ss:SSS", true));
	}

}
