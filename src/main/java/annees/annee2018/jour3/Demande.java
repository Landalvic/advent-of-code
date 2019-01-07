package annees.annee2018.jour3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Demande {

	private int id;
	private List<AtomicInteger> morceaux;

	public Demande(int id) {
		super();
		this.id = id;
		morceaux = new ArrayList<>();
	}

	public boolean isSeul() {
		for (AtomicInteger integer : morceaux) {
			if (integer.get() >= 2) {
				return false;
			}
		}
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<AtomicInteger> getMorceaux() {
		return morceaux;
	}

	public void setMorceaux(List<AtomicInteger> morceaux) {
		this.morceaux = morceaux;
	}

}
