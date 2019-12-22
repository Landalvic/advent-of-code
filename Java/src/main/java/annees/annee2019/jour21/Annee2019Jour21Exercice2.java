package annees.annee2019.jour21;

import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour21Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour21Exercice2().lancer("src/main/resources/annee2019/jour21/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		code.init();
		while (!code.isFini()) {
			List<Long> retour = code.lancerAttendreInput(code.ecrireAscii("NOT C J\n"));
			System.out.println(code.lireAscii(retour));
			retour = code.lancerAttendreInput(code.ecrireAscii("OR D T\n"));
			System.out.println(code.lireAscii(retour));
			retour = code.lancerAttendreInput(code.ecrireAscii("AND T J\n"));
			System.out.println(code.lireAscii(retour));
			retour = code.lancerAttendreInput(code.ecrireAscii("AND H T\n"));
			System.out.println(code.lireAscii(retour));
			retour = code.lancerAttendreInput(code.ecrireAscii("AND T J\n"));
			System.out.println(code.lireAscii(retour));

			retour = code.lancerAttendreInput(code.ecrireAscii("NOT B T\n"));
			System.out.println(code.lireAscii(retour));
			retour = code.lancerAttendreInput(code.ecrireAscii("AND D T\n"));
			System.out.println(code.lireAscii(retour));
			retour = code.lancerAttendreInput(code.ecrireAscii("OR T J\n"));
			System.out.println(code.lireAscii(retour));

			retour = code.lancerAttendreInput(code.ecrireAscii("NOT A T\n"));
			System.out.println(code.lireAscii(retour));
			retour = code.lancerAttendreInput(code.ecrireAscii("OR T J\n"));
			System.out.println(code.lireAscii(retour));
			retour = code.lancerAttendreInput(code.ecrireAscii("RUN\n"));
			System.out.println(code.lireAscii(retour));
			System.out.println(retour.get(retour.size() - 1));
		}
		return "";
	}

}
