package annees.annee2019.jour06;

import java.util.HashSet;
import java.util.Set;

public class Orbite {

	private String code;
	private Set<Orbite> parents = new HashSet<>();
	private Set<Orbite> enfants = new HashSet<>();

	public Orbite(String code) {
		super();
		this.code = code;
	}

	public int calculerParents() {
		int total = parents.size();
		for (Orbite orbite : parents) {
			total += orbite.calculerParents();
		}
		return total;
	}

	public void ajouterEnfant(Orbite orbite) {
		enfants.add(orbite);
		orbite.getParents().add(this);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Orbite> getParents() {
		return parents;
	}

	public void setParents(Set<Orbite> parents) {
		this.parents = parents;
	}

	public Set<Orbite> getEnfants() {
		return enfants;
	}

	public void setEnfants(Set<Orbite> enfants) {
		this.enfants = enfants;
	}

	@Override
	public String toString() {
		return "Orbite [code=" + code + "]";
	}

}
