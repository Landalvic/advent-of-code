package commun;

import java.util.LinkedList;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamSearch<T, U> extends StreamHistory<T> {

	private U u;
	private T current;

	public StreamSearch() {
		super(0);
	}

	@Override
	public void init() {
		liste = new LinkedList<>();
		index = -1;
	}

	@Override
	public boolean checkListeFull() {
		return false;
	}

	@Override
	public StreamHistory<T> save(T curElem) {
		if (current != null) {
			liste.add(current);
		}
		current = curElem;
		return this;
	}

	@Override
	public int indexCurrentInList() {
		return liste.size();
	}

	@Override
	public T current() {
		return current;
	}

	@Override
	public T next(int i) {
		return null;
	}

	public U findCondition(Stream<T> stream, Function<StreamHistory<T>, U> function) {
		var any = stream(stream).anyMatch(i -> {
			u = function.apply(i);
			return u != null;
		});
		return any ? u : null;
	}

}
