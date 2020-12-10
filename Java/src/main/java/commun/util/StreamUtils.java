package commun.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.ObjIntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public interface StreamUtils {

	public static Stream<String> chars(String texte) {
		return texte.chars().mapToObj(i -> String.valueOf((char) i));
	}

	public static boolean charEquals(char c, String lettre) {
		return StringUtils.equals(String.valueOf(c), lettre);
	}

	public static <T> Stream<T> filterWithIndex(Stream<T> stream, BiPredicate<T, Integer> fonction) {
		AtomicInteger index = new AtomicInteger();
		return stream.filter(item -> fonction.test(item, index.getAndIncrement()));
	}

	public static <T> Stream<T> mapWithIndex(Stream<T> stream, BiFunction<T, Integer, T> fonction) {
		AtomicInteger index = new AtomicInteger();
		return stream.map(item -> fonction.apply(item, index.getAndIncrement()));
	}

	public static <T> void forEachWithIndex(Stream<T> stream, ObjIntConsumer<T> fonction) {
		AtomicInteger index = new AtomicInteger();
		stream.forEach(item -> fonction.accept(item, index.getAndIncrement()));
	}

	public static <T> IntStream mapToIntWithIndex(Stream<T> stream, BiFunction<T, Integer, Integer> fonction) {
		AtomicInteger index = new AtomicInteger();
		return stream.mapToInt(item -> fonction.apply(item, index.getAndIncrement()));
	}

}
