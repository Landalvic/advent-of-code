package annees.annee2020.jour04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Passeport {

	private Map<String, String> infos;

	public Passeport() {
		super();
		this.infos = new HashMap<>();
	}

	public void ajouterInfos(String ligne) {
		var blocs = Arrays.asList(ligne.split(" ", -1));
		for (String string : blocs) {
			String[] sblocs = string.split(":", -1);
			infos.put(sblocs[0], sblocs[1]);
		}
	}

	public Map<String, String> getInfos() {
		return infos;
	}

	public void setInfos(Map<String, String> infos) {
		this.infos = infos;
	}

}
