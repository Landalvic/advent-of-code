package annees.annee2020.jour04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import commun.structure.ExerciceInputBlocToObject;
import commun.util.TexteUtils;

public abstract class Annee2020Jour4 extends ExerciceInputBlocToObject<Passeport> {

	protected Map<String, Pattern> infos = new HashMap<>();

	protected Annee2020Jour4(int exercice) {
		super(2020, 4, exercice);
	}

	@Override
	protected void init() {
		infos = new HashMap<>();
	}

	@Override
	protected Passeport blocToObject(List<String> blocs) {
		var passeport = new Passeport();
		for (String string : blocs) {
			passeport.ajouterInfos(string);
		}
		return passeport;
	}

	protected boolean gererPasseport(Passeport p) {
		for (var entry : infos.entrySet()) {
			if (!p.getInfos().containsKey(entry.getKey())
					|| (entry.getValue() != null && !TexteUtils.findPattern(p.getInfos().get(entry.getKey()), entry.getValue()))) {
				return false;
			}
		}
		return true;
	}

}
