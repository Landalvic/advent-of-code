package annees.annee2018.jour21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import annees.annee2018.jour16.Operation;
import annees.annee2018.jour16.OperationRunnable;
import annees.annee2018.jour16.operations.AddI;
import annees.annee2018.jour16.operations.AddR;
import annees.annee2018.jour16.operations.BanI;
import annees.annee2018.jour16.operations.BanR;
import annees.annee2018.jour16.operations.BorI;
import annees.annee2018.jour16.operations.BorR;
import annees.annee2018.jour16.operations.EqIR;
import annees.annee2018.jour16.operations.EqRI;
import annees.annee2018.jour16.operations.EqRR;
import annees.annee2018.jour16.operations.GtIR;
import annees.annee2018.jour16.operations.GtRI;
import annees.annee2018.jour16.operations.GtRR;
import annees.annee2018.jour16.operations.MulI;
import annees.annee2018.jour16.operations.MulR;
import annees.annee2018.jour16.operations.SetI;
import annees.annee2018.jour16.operations.SetR;
import commun.util.FileUtils;

public class Jour21Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour21/data.txt");
		List<Operation> operations = new ArrayList<>(liste.size());
		List<OperationRunnable> calculs = Arrays.asList(new AddI(), new AddR(), new BanI(), new BanR(), new BorI(),
				new BorR(), new EqIR(), new EqRI(), new EqRR(), new GtIR(), new GtRI(), new GtRR(), new MulI(),
				new MulR(), new SetI(), new SetR());
		HashMap<String, OperationRunnable> mapOperations = new HashMap<>();
		for (OperationRunnable operationRunnable : calculs) {
			mapOperations.put(operationRunnable.getId(), operationRunnable);
		}
		int instructionBinder = Integer.valueOf(liste.remove(0).split(" ")[1]);
		for (int i = 0; i < liste.size(); i++) {
			Operation operation = new Operation();
			String[] ligne = liste.get(i).split(" ");
			operation.setOperation(mapOperations.get(ligne[0]));
			operation.setA(Integer.valueOf(ligne[1]));
			operation.setB(Integer.valueOf(ligne[2]));
			operation.setC(Integer.valueOf(ligne[3]));
			operations.add(operation);
		}

		long[] registres = new long[6];
		registres[0] = 10780777;
		int instructionPointer = 0;
		while (true) {
			if (instructionPointer < 0 || instructionPointer >= operations.size()) {
				break;
			}
			Operation operation = operations.get(instructionPointer);
			registres[instructionBinder] = instructionPointer;
			operation.setRegisters(registres);
			registres = operation.getOperation().run(operation);
			instructionPointer = (int) registres[instructionBinder];
			instructionPointer++;
			// System.out.println(Arrays.toString(registres) + " - " +
			// instructionPointer);
		}
		System.out.println(registres[0]);
	}

}
