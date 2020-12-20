package annees.annee2020.jour16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;
import commun.util.TexteUtils;

public abstract class Annee2020Jour16 extends Exercice {

	protected Pattern patternInfos = Pattern.compile("^(.*): (.*)-(.*) or (.*)-(.*)$");
	protected Map<String, Infos> infos;
	protected Ticket vous;
	protected List<Ticket> autres;

	public Annee2020Jour16(int exercice) {
		super(2020, 16, exercice);
	}

	@Override
	protected void init() {
		vous = new Ticket();
		infos = new HashMap<>();
		autres = new ArrayList<>();
	}

	protected void chargerInput(String input) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		for (int i = 0; i < lignes.size(); i++) {
			String ligne = lignes.get(i);
			if (TexteUtils.findPattern(ligne, patternInfos)) {
				var blocs = TexteUtils.trouverPattern(ligne, patternInfos, 5);
				Infos inf = new Infos();
				inf.setId(blocs[0]);
				inf.setMin1(Integer.parseInt(blocs[1]));
				inf.setMax1(Integer.parseInt(blocs[2]));
				inf.setMin2(Integer.parseInt(blocs[3]));
				inf.setMax2(Integer.parseInt(blocs[4]));
				infos.put(blocs[0], inf);
			} else if (ligne.equals("your ticket:")) {
				String vousS = lignes.get(i + 1);
				vous.setChamps(chargerChamp(vousS));
			} else if (ligne.equals("nearby tickets:")) {
				for (int j = 1; i + j < lignes.size(); j++) {
					String autreS = lignes.get(i + j);
					Ticket autre = new Ticket();
					autre.setChamps(chargerChamp(autreS));
					autres.add(autre);
				}
			}
		}
	}

	private List<Integer> chargerChamp(String s) {
		return Stream.of(s.split(",", -1)).map(Integer::parseInt).collect(Collectors.toList());
	}

}
