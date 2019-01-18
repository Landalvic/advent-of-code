package annees.annee2018.jour02;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import commun.Exercice;
import util.FileUtils;

public class Annee2018Jour2Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2018Jour2Exercice1().lancer("src/main/resources/annee2018/jour02/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		Stream<String> stream = FileUtils.streamOfLines(input);
		AtomicInteger total2Fois = new AtomicInteger(0);
		AtomicInteger total3Fois = new AtomicInteger(0);
		stream.forEach(string -> {
			Map<Integer, Long> comptage = string.chars().boxed().collect(groupingBy(identity(), counting()));
			if (comptage.values().contains(2L)) {
				total2Fois.incrementAndGet();
			}
			if (comptage.values().contains(3L)) {
				total3Fois.incrementAndGet();
			}
		});
		return String.valueOf(total2Fois.get() * total3Fois.get());
	}

}
