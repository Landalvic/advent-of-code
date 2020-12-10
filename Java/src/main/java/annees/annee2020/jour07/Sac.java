package annees.annee2020.jour07;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Sac {

	private String type;
	private String conteneur;
	private List<Sac> sacs = new ArrayList<Sac>();
	private List<Integer> nombres = new ArrayList<Integer>();

	public void trouverConteneur(List<Sac> sacs) {
		var blocs = conteneur.split(",", -1);
		for (String string : blocs) {
			if (!string.isEmpty() && !StringUtils.equals("no other bags", conteneur.trim())) {
				var newS = string.replace("bags", "").trim();
				var newT = newS.substring(2).replace("bags", "").replace("bag", "").trim();
				nombres.add(Integer.parseInt(String.valueOf(newS.charAt(0))));
				boolean trouve = false;
				for (var sac : sacs) {
					if (StringUtils.equals(sac.getType(), newT)) {
						this.sacs.add(sac);
						trouve = true;
						break;
					}
				}
				if (!trouve) {
					Sac newSac = new Sac();
					newSac.setType(newT);
					newSac.setConteneur("");
					sacs.add(newSac);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Sac [type=" + type + ", sacs=" + sacs + "]";
	}

	public List<Sac> getSacs() {
		return sacs;
	}

	public void setSacs(List<Sac> sacs) {
		this.sacs = sacs;
	}

	public List<Integer> getNombres() {
		return nombres;
	}

	public void setNombres(List<Integer> nombres) {
		this.nombres = nombres;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConteneur() {
		return conteneur;
	}

	public void setConteneur(String conteneur) {
		this.conteneur = conteneur;
	}

}
