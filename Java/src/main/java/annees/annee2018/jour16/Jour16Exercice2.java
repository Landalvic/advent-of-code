package annees.annee2018.jour16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

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

public class Jour16Exercice2 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour16/data-sample.txt");
		List<String> liste2 = FileUtils.lireFichier("./jour16/data-program.txt");
		Pattern beforePattern = Pattern.compile("Before: \\[(.*)\\]");
		Pattern afterPattern = Pattern.compile("After:  \\[(.*)\\]");
		List<Operation> operations = new ArrayList<>(liste.size());
		List<Operation> programme = new ArrayList<>(liste.size());
		List<OperationRunnable> calculs = Arrays.asList(new AddI(), new AddR(), new BanI(), new BanR(), new BorI(),
				new BorR(), new EqIR(), new EqRI(), new EqRR(), new GtIR(), new GtRI(), new GtRR(), new MulI(),
				new MulR(), new SetI(), new SetR());
		for (int i = 0; i < liste.size(); i += 4) {
			Operation operation = new Operation();
			String[] before = FileUtils.trouverPattern(liste.get(i), beforePattern).split(",");
			String[] opcode = liste.get(i + 1).split(" ");
			String[] after = FileUtils.trouverPattern(liste.get(i + 2), afterPattern).split(",");
			for (int j = 0; j < before.length; j++) {
				operation.getRegisters()[j] = Integer.valueOf(before[j].trim());
			}
			for (int j = 0; j < after.length; j++) {
				operation.getResultatAttendu()[j] = Integer.valueOf(after[j].trim());
			}
			operation.setOpcode(Integer.valueOf(opcode[0]));
			operation.setA(Integer.valueOf(opcode[1]));
			operation.setB(Integer.valueOf(opcode[2]));
			operation.setC(Integer.valueOf(opcode[3]));
			operations.add(operation);
		}
		for (int i = 0; i < liste2.size(); i++) {
			Operation operation = new Operation();
			String[] opcode = liste2.get(i).split(" ");
			operation.setOpcode(Integer.valueOf(opcode[0]));
			operation.setA(Integer.valueOf(opcode[1]));
			operation.setB(Integer.valueOf(opcode[2]));
			operation.setC(Integer.valueOf(opcode[3]));
			programme.add(operation);
		}
		for (Operation operation : operations) {
			for (OperationRunnable calcul : calculs) {
				long[] resultat = calcul.run(operation);
				if (!egalite(resultat, operation.getResultatAttendu())) {
					calcul.getIdsPossibles().remove(Integer.valueOf(operation.getOpcode()));
				}
			}
		}
		while (!onlyOneId(calculs)) {
			for (OperationRunnable calcul : calculs) {
				if (calcul.getIdsPossibles().size() == 1) {
					for (OperationRunnable calcul2 : calculs) {
						if (calcul2 != calcul) {
							calcul2.getIdsPossibles().remove(Integer.valueOf(calcul.getIdsPossibles().get(0)));
						}
					}
				}
			}
		}
		long[] depart = new long[4];
		for (Operation ligneProgramme : programme) {
			ligneProgramme.setRegisters(depart);
			OperationRunnable calcul = null;
			for (OperationRunnable operationRunnable : calculs) {
				if (operationRunnable.getIdsPossibles().get(0).intValue() == ligneProgramme.getOpcode()) {
					calcul = operationRunnable;
					break;
				}
			}
			depart = calcul.run(ligneProgramme);
		}
		System.out.println(depart[0]);
	}

	private static boolean onlyOneId(List<OperationRunnable> calculs) {
		for (OperationRunnable calcul : calculs) {
			if (calcul.getIdsPossibles().size() > 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean egalite(long[] t1, long[] t2) {
		for (int i = 0; i < t2.length && i < t1.length; i++) {
			if (t1[i] != t2[i]) {
				return false;
			}
		}
		return t2.length == t1.length;
	}

}
