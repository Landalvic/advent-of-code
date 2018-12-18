package jours.jour7;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Etape implements Comparable<Etape> {

	private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private String id;
	private List<Etape> conditions;
	private boolean fini;
	private int temps;

	public Etape(String id) {
		super();
		this.id = id;
		conditions = new ArrayList<>();
		fini = false;
		temps = 61 + indexOf(alphabet, id);
	}

	public static int indexOf(char[] tab, String val) {
		int index = -1;
		for (int i = 0; i < tab.length; i++) {
			if (StringUtils.equalsIgnoreCase("" + tab[i], val)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public boolean resteConditions() {
		for (Etape etape : conditions) {
			if (!etape.isFini()) {
				return true;
			}
		}
		return false;
	}

	public boolean isFini() {
		return fini;
	}

	public void setFini(boolean fini) {
		this.fini = fini;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Etape> getConditions() {
		return conditions;
	}

	public void setConditions(List<Etape> conditions) {
		this.conditions = conditions;
	}

	@Override
	public int compareTo(Etape o) {
		return id.compareTo(o.id);
	}

	@Override
	public String toString() {
		return "Etape [id=" + id + "]";
	}

}
