package commun;

public class SimpleCase<T> extends Case<SimpleCase<T>> {

	private T id;

	public SimpleCase(InterfaceMap<SimpleCase<T>> map, Position position) {
		super(map, position);
	}

	public SimpleCase(InterfaceMap<SimpleCase<T>> map, Position position, T id) {
		super(map, position);
		this.id = id;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	@Override
	public SimpleCase<T> getThis() {
		return this;
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
