package commun;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Hierarchies<T extends Infos> {

	private Map<String, Hierarchie<T>> listeHierarchie;

	public Hierarchies() {
		super();
		listeHierarchie = new HashMap<>();
	}

	public Collection<Hierarchie<T>> listeHierarchie() {
		return listeHierarchie.values();
	}

	public Hierarchie<T> trouver(String id) {
		return listeHierarchie.get(id);
	}

	public Hierarchie<T> trouverOuAjouter(T infos) {
		var hierarchie = listeHierarchie.get(infos.getId());
		if (hierarchie == null) {
			return new Hierarchie<>(this, infos);
		} else {
			return hierarchie;
		}
	}

	public void ajouter(Hierarchie<T> hierarchie) {
		if (!listeHierarchie.containsKey(hierarchie.getInfos().getId())) {
			listeHierarchie.put(hierarchie.getInfos().getId(), hierarchie);
		}
	}

	public Map<String, Hierarchie<T>> getListeHierarchie() {
		return listeHierarchie;
	}

	public void setListeHierarchie(Map<String, Hierarchie<T>> listeHierarchie) {
		this.listeHierarchie = listeHierarchie;
	}

}
