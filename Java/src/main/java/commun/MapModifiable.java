package commun;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MapModifiable<T extends Case<T>> implements InterfaceMap<T> {

	protected Map<Position, T> cases;

	public MapModifiable() {
		super();
		cases = new HashMap<>();
	}

	@Override
	public double minX() {
		return cases.keySet().stream().mapToDouble(Position::getX).min().orElseThrow();
	}

	@Override
	public double minY() {
		return cases.keySet().stream().mapToDouble(Position::getY).min().orElseThrow();
	}

	@Override
	public double maxX() {
		return cases.keySet().stream().mapToDouble(Position::getX).max().orElseThrow();
	}

	@Override
	public double maxY() {
		return cases.keySet().stream().mapToDouble(Position::getY).max().orElseThrow();
	}

	@Override
	public T getCase(Position position) {
		return cases.get(position);
	}

	@Override
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

	@Override
	public void forEach(Consumer<T> consume) {
		streamAllCase().forEach(consume);
	}

	@Override
	public boolean anyMatch(Predicate<T> consume) {
		return streamAllCase().anyMatch(consume);
	}

}
