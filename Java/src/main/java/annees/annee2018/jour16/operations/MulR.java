package annees.annee2018.jour16.operations;

import annees.annee2018.jour16.Operation;
import annees.annee2018.jour16.OperationRunnable;

public class MulR extends OperationRunnable {

	public long[] run(Operation operation) {
		long[] resultat = operation.getRegisters().clone();
		resultat[operation.getC()] = operation.getRegisters()[operation.getA()]
				* operation.getRegisters()[operation.getB()];
		return resultat;
	}

	@Override
	public String getId() {
		return "mulr";
	}

}
