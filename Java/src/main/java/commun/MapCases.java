package commun;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MapCases<T extends Case<T>> {

	protected Map<Position, T> cases;

	public MapCases() {
		super();
		cases = new HashMap<>();
	}

	public T getOrAddCase(Position position, Function<Position, T> creation) {
		T t = cases.get(position);
		if (t != null) {
			return t;
		} else if (creation == null) {
			return null;
		} else {
			t = creation.apply(position);
			addCase(t);
			return t;
		}
	}

	public T getCase(Position position) {
		return cases.get(position);
	}

	public T getCase(int... coordonnees) {
		return getCase(new Position(coordonnees));
	}

	public T getCase(double... coordonnees) {
		return getCase(new Position(coordonnees));
	}

	public void addAllCase(Collection<T> collection) {
		for (T t : collection) {
			addCase(t);
		}
	}

	public void addCase(T t) {
		cases.put(t.getPosition(), t);
	}

	public Map<Position, T> getCases() {
		return cases;
	}

	public void setCases(Map<Position, T> cases) {
		this.cases = cases;
	}

	public Stream<T> streamAllCase() {
		return cases.values().stream();
	}

	public Collection<T> listeAllCase() {
		return cases.values();
	}

	public Collection<T> listCopyAllCase() {
		return new HashSet<>(cases.values());
	}

	public boolean removeIf(Predicate<T> predicate) {
		return cases.values().removeIf(predicate);
	}

}
