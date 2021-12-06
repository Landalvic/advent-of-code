package commun;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamHistory<T> {

	protected int nbrPrevious;
	protected int nbrNext;
	protected int index;
	protected List<T> liste;

	public StreamHistory(int nbrPrevious) {
		this.nbrPrevious = nbrPrevious;
		init();
	}

	public StreamHistory(int nbrPrevious, int nbrNext) {
		this.nbrPrevious = nbrPrevious;
		this.nbrNext = nbrNext;
		init();
	}

	public void init() {
		liste = new ArrayList<>(nbrPrevious + nbrNext + 1);
		index = -1;
	}

	public Stream<StreamHistory<T>> stream(Stream<T> stream) {
		init();
		return stream.map(this::save);
	}

	public Stream<StreamHistory<T>> streamWithoutNull(Stream<T> stream) {
		init();
		return stream(stream).filter(StreamHistory::checkListeFull);
	}

	public StreamHistory<T> save(T curElem) {
		index++;
		if (checkListeFull()) {
			liste.remove(0);
		}
		liste.add(curElem);
		return this;
	}

	public boolean checkListeFull() {
		return liste.size() == nbrPrevious + nbrNext + 1;
	}

	public int getIndex() {
		return index - nbrNext;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int indexCurrentInList() {
		return liste.size() - 1 - nbrNext;
	}

	public T current() {
		return liste.get(indexCurrentInList());
	}

	public T previous(int i) {
		return liste.get(indexCurrentInList() - i);
	}

	public T next(int i) {
		return liste.get(indexCurrentInList() + i);
	}

	public int getNbrPrevious() {
		return nbrPrevious;
	}

	public void setNbrPrevious(int nbrPrevious) {
		this.nbrPrevious = nbrPrevious;
	}

	public List<T> getListe() {
		return liste;
	}

	public void setListe(List<T> liste) {
		this.liste = liste;
	}

	public int getNbrNext() {
		return nbrNext;
	}

	public void setNbrNext(int nbrNext) {
		this.nbrNext = nbrNext;
	}
}
