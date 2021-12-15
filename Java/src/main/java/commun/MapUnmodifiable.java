package commun;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MapUnmodifiable<T extends Case<T>> implements InterfaceMap<T> {

	protected T[][] cases;

	public MapUnmodifiable(T[][] cases) {
		super();
		this.cases = cases;
	}

	@Override
	public double minX() {
		return 0;
	}

	@Override
	public double minY() {
		return 0;
	}

	@Override
	public double maxX() {
		return cases.length - 1.;
	}

	@Override
	public double maxY() {
		return cases[0].length - 1.;
	}

	@Override
	public T getCase(Position position) {
		return byPosition(position);
	}

	@Override
	public void addCase(T t) {
		cases[(int) t.getPosition().getX()][(int) t.getPosition().getY()] = t;
	}

	private T byPosition(Position position) {
		try {
			return cases[(int) position.getX()][(int) position.getY()];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public void forEach(Consumer<T> consume) {
		for (T[] ts : cases) {
			for (T t : ts) {
				consume.accept(t);
			}
		}
	}

	@Override
	public boolean anyMatch(Predicate<T> consume) {
		for (T[] ts : cases) {
			for (T t : ts) {
				if (consume.test(t)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Stream<T> streamAllCase() {
		return null;
	}

	@Override
	public Collection<T> listeAllCase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<T> listCopyAllCase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		// TODO Auto-generated method stub
		return false;
	}

}
