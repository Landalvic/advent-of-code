package annees.annee2019.jour02;

import annees.annee2019.IntCode;
import commun.structure.Exercice;

public abstract class Annee2019Jour2 extends Exercice {

	protected Annee2019Jour2(int exercice) {
		super(2019, 2, exercice);
	}

	protected long lancerCode(IntCode code, long input1, long input2) {
		if (!test) {
			code.setBloc(1, input1);
			code.setBloc(2, input2);
		}
		code.lancer();
		return code.getBloc(0);
	}

}
