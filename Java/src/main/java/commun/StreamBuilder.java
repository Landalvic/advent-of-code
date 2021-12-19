package commun;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StreamBuilder {

	private StringBuilder builder;
	private int index;

	public StreamBuilder(StringBuilder builder) {
		super();
		this.builder = builder;
	}

	public StreamBuilder() {
		super();
		builder = new StringBuilder();
	}

	public StreamBuilder(String texte) {
		super();
		builder = new StringBuilder(texte);
	}

	public StreamBuilder(String texte, String separator) {
		super();
		var blocs = texte.split(separator);
		builder = new StringBuilder(String.join("", blocs));
	}

	public <T> T find(Function<String, T> find) {
		index = 0;
		while (index < builder.length()) {
			String c = charAt(index);
			T t = find.apply(c);
			if (t != null) {
				return t;
			}
			index += 1;
		}
		return null;
	}

	public <T> T reduce(T depart, BiFunction<T, String, T> reduce) {
		index = 0;
		while (index < builder.length()) {
			String c = charAt(index);
			depart = reduce.apply(depart, c);
			index += 1;
		}
		return depart;
	}

	public StreamBuilder forEach(Consumer<String> forEach) {
		index = 0;
		while (index < builder.length()) {
			String c = charAt(index);
			forEach.accept(c);
			index += 1;
		}
		return this;
	}

	public StreamBuilder map(UnaryOperator<String> map) {
		index = 0;
		StringBuilder newBuilder = new StringBuilder();
		while (index < builder.length()) {
			String c = charAt(index);
			newBuilder.append(map.apply(c));
			index += 1;
		}
		builder = newBuilder;
		return this;
	}

	public String substring(int start, int end) {
		return builder.substring(start, end);
	}

	public String substring(int start) {
		return builder.substring(start);
	}

	public String charAt(int index) {
		return String.valueOf(builder.charAt(index));
	}

	public StreamBuilder delete(int start, int end) {
		builder.delete(start, end);
		return this;
	}

	public StreamBuilder reverse() {
		builder.reverse();
		return this;
	}

	public int size() {
		return builder.length();
	}

	public StringBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(StringBuilder builder) {
		this.builder = builder;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void addIndex(int d) {
		this.index += d;
	}

	@Override
	public String toString() {
		return builder.toString();
	}

}
