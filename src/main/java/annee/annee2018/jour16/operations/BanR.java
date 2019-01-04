package annee.annee2018.jour16.operations;

import annee.annee2018.jour16.Operation;
import annee.annee2018.jour16.OperationRunnable;

public class BanR extends OperationRunnable {

	public long[] run(Operation operation) {
		long[] resultat = operation.getRegisters().clone();
		resultat[operation.getC()] = operation.getRegisters()[operation.getA()]
				& operation.getRegisters()[operation.getB()];
		return resultat;
	}

	@Override
	public String getId() {
		return "banr";
	}

}
