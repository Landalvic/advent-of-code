package annees.annee2019.jour02;

import annees.annee2019.IntCode;
import commun.structure.Exercice;

public abstract class Annee2019Jour2 extends Exercice {

	public Annee2019Jour2(int exercice) {
		super(2019, 2, exercice);
	}

	@Override
	protected void init() {}

	protected String lancerCode(IntCode code, int input1, int input2) {
		if (!test) {
			code.setBloc(1, String.valueOf(input1));
			code.setBloc(2, String.valueOf(input2));
		}
		code.lancer();
		return code.getBloc(0);
	}

}
