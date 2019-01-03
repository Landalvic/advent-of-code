package jours.jour16.operations;

import jours.jour16.Operation;
import jours.jour16.OperationRunnable;

public class SetI extends OperationRunnable {

	public long[] run(Operation operation) {
		long[] resultat = operation.getRegisters().clone();
		resultat[operation.getC()] = operation.getA();
		return resultat;
	}

	@Override
	public String getId() {
		return "seti";
	}

}
