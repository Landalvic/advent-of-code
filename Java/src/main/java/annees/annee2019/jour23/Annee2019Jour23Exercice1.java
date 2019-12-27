package annees.annee2019.jour23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour23Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour23Exercice1().lancer("src/main/resources/annee2019/jour23/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		List<IntCode> codes = new ArrayList<>();
		List<Operation> operations = new ArrayList<>();
		Operation nat = null;
		for (int i = 0; i < 50; i++) {
			var code = new IntCode(ligne);
			code.init();
			code.setAdresse(i);
			var retour = code.lancer(3, Arrays.asList((long) i));
			retour = code.lancer(3, Arrays.asList(-1L));
			if (!retour.isEmpty()) {
				operations
						.add(new Operation(retour.get(0).intValue(), retour.get(1), retour.get(2), code.getNbrEtape()));
			}
			codes.add(code);
		}
		while (!allCodeFinished(codes)) {
			if (operations.isEmpty()) {
				for (IntCode code : codes) {
					var retour = code.lancer(3, Arrays.asList(-1L));
					if (!retour.isEmpty()) {
						if (retour.get(0).intValue() == 255) {
							nat = new Operation(retour.get(0).intValue(), retour.get(1), retour.get(2),
									code.getNbrEtape());
						} else {
							operations.add(new Operation(retour.get(0).intValue(), retour.get(1), retour.get(2),
									code.getNbrEtape()));
						}
					}
				}
				if (operations.isEmpty()) {
					var code = chercherCode(codes, 0);
					var retour = code.lancer(3, Arrays.asList(nat.getX(), nat.getY()));
					if (retour.get(0).intValue() == 255) {
						System.out.println("y1:" + nat.getY());
						System.out.println("y2:" + retour.get(2));
						break;
					} else {
						operations.add(new Operation(retour.get(0).intValue(), retour.get(1), retour.get(2),
								code.getNbrEtape()));
					}
				}
			}
			Collections.sort(operations);
			Operation op = operations.remove(0);
			var code = chercherCode(codes, op.getAdresse());
			var retour = code.lancer(3, Arrays.asList(op.getX(), op.getY()));
			if (!retour.isEmpty()) {
				operations
						.add(new Operation(retour.get(0).intValue(), retour.get(1), retour.get(2), code.getNbrEtape()));
			}
		}
		return "";
	}

	private IntCode chercherCode(List<IntCode> codes, int adresse) {
		for (IntCode intCode : codes) {
			if (intCode.getAdresse() == adresse) {
				return intCode;
			}
		}
		return null;
	}

	private boolean allCodeFinished(List<IntCode> codes) {
		for (IntCode intCode : codes) {
			if (!intCode.isFini()) {
				return false;
			}
		}
		return true;
	}

}
