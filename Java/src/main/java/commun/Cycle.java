package commun;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cycle<T> {

	private List<T> liste;
	private boolean cycleFini;

	public Cycle() {
		super();
		liste = new ArrayList<>();
		cycleFini = false;
	}

	private void verifierCycle() {
		if (!cycleFini && liste.size() % 2 == 0) {
			int tailleMoitie = liste.size() / 2;
			boolean fini = true;
			for (int i = 0; i < tailleMoitie; i++) {
				if (!Objects.deepEquals(liste.get(i), liste.get(tailleMoitie + i))) {
					fini = false;
					break;
				}
			}
			if (fini) {
				cycleFini = true;
				liste = liste.subList(0, tailleMoitie);
			}
		}
	}

	public boolean isCycleFini() {
		return cycleFini;
	}

	public void add(T t) {
		if (!cycleFini) {
			liste.add(t);
			verifierCycle();
		}
	}

	public int size() {
		return liste.size();
	}

}
