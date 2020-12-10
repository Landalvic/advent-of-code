package annees.annee2019.jour19;

import java.util.ArrayList;
import java.util.List;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2019Jour19Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour19Exercice1().lancer("src/main/resources/annee2019/jour19/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		List<Long> inputs = new ArrayList<Long>();
		long x = 0;
		long y = 0;
		long nbr = 0;
		while (x < 50 && y < 50) {
			inputs.add(x);
			inputs.add(y);
			code.init();
			Long retour = code.lancerFirstOutput(inputs);
			nbr += retour;
			x++;
			if (x > 49) {
				y++;
				x = 0L;
				System.out.println(y);
			}
		}
		return "" + nbr;
	}

}
