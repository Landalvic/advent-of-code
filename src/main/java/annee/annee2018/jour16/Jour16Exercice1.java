package annee.annee2018.jour16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import annee.annee2018.jour16.operations.AddI;
import annee.annee2018.jour16.operations.AddR;
import annee.annee2018.jour16.operations.BanI;
import annee.annee2018.jour16.operations.BanR;
import annee.annee2018.jour16.operations.BorI;
import annee.annee2018.jour16.operations.BorR;
import annee.annee2018.jour16.operations.EqIR;
import annee.annee2018.jour16.operations.EqRI;
import annee.annee2018.jour16.operations.EqRR;
import annee.annee2018.jour16.operations.GtIR;
import annee.annee2018.jour16.operations.GtRI;
import annee.annee2018.jour16.operations.GtRR;
import annee.annee2018.jour16.operations.MulI;
import annee.annee2018.jour16.operations.MulR;
import annee.annee2018.jour16.operations.SetI;
import annee.annee2018.jour16.operations.SetR;
import util.FileUtils;

public class Jour16Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour16/data-sample.txt");
		Pattern beforePattern = Pattern.compile("Before: \\[(.*)\\]");
		Pattern afterPattern = Pattern.compile("After:  \\[(.*)\\]");
		List<Operation> operations = new ArrayList<>(liste.size());
		List<Operation> operationsPlusDe3 = new ArrayList<>(liste.size());
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
		for (Operation operation : operations) {
			int nbrEgalite = 0;
			for (OperationRunnable calcul : calculs) {
				long[] resultat = calcul.run(operation);
				if (egalite(resultat, operation.getResultatAttendu())) {
					nbrEgalite++;
				}
			}
			if (nbrEgalite >= 3) {
				operationsPlusDe3.add(operation);
			}
		}
		System.out.println(operationsPlusDe3.size());
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
