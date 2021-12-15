package commun;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface InterfaceMap<T extends Case<T>> {

	default double width() {
		return maxX() - minX() + 1;
	}

	default double height() {
		return maxY() - minY() + 1;
	}

	public double minX();

	public double minY();

	public double maxX();

	public double maxY();

	default T getOrAddCase(Position position, Function<Position, T> creation) {
		T t = getCase(position);
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

	public T getCase(Position position);

	default T getCase(int... coordonnees) {
		return getCase(new Position(coordonnees));
	}

	default T getCase(double... coordonnees) {
		return getCase(new Position(coordonnees));
	}

	default void addAllCase(Collection<T> collection) {
		for (T t : collection) {
			addCase(t);
		}
	}

	public void forEach(Consumer<T> consume);

	public boolean anyMatch(Predicate<T> consume);

	public void addCase(T t);

	public Stream<T> streamAllCase();

	public Collection<T> listeAllCase();

	public Collection<T> listCopyAllCase();

	public boolean removeIf(Predicate<T> predicate);

}
