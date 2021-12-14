package commun;

import java.util.ArrayList;
import java.util.Collection;

public class Chemin<T, U extends Infos> extends ArrayList<T> {

	private static final long serialVersionUID = 1L;

	private U infos;

	public Chemin(Chemin<T, U> chemin) {
		super(chemin);
		infos = chemin.infos;
	}

	public Chemin() {
		super();
	}

	public Chemin(Collection<? extends T> c) {
		super(c);
	}

	public Chemin(int initialCapacity) {
		super(initialCapacity);
	}

	public U getInfos() {
		return infos;
	}

	public void setInfos(U infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "CheminTest [infos=" + infos + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
