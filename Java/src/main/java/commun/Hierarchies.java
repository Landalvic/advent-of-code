package commun;

import java.util.HashMap;
import java.util.Map;

public class Hierarchies {

	private Map<String, Hierarchie> listeHierarchie;

	public Hierarchies() {
		super();
		listeHierarchie = new HashMap<>();
	}

	public Hierarchie trouver(String id) {
		return listeHierarchie.get(id);
	}

	public Hierarchie trouverOuAjouter(String id) {
		var hierarchie = listeHierarchie.get(id);
		if (hierarchie == null) {
			return new Hierarchie(this, id);
		} else {
			return hierarchie;
		}
	}

	public void ajouter(Hierarchie hierarchie) {
		if (!listeHierarchie.containsKey(hierarchie.getId())) {
			listeHierarchie.put(hierarchie.getId(), hierarchie);
		}
	}

	public Map<String, Hierarchie> getListeHierarchie() {
		return listeHierarchie;
	}

	public void setListeHierarchie(Map<String, Hierarchie> listeHierarchie) {
		this.listeHierarchie = listeHierarchie;
	}

}
