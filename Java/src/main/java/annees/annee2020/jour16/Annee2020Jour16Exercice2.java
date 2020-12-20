package annees.annee2020.jour16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour16Exercice2 extends Annee2020Jour16 {

	public static void main(String[] args) {
		new Annee2020Jour16Exercice2().lancer(true);
	}

	public Annee2020Jour16Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		chargerInput(input);
		List<Ticket> bonsTickets = autres.stream().filter(ticket -> ticket.getChamps().stream().noneMatch(champ -> infos.values().stream()
				.noneMatch(info -> (champ >= info.getMin1() && champ <= info.getMax1()) || (champ >= info.getMin2() && champ <= info.getMax2()))))
				.collect(Collectors.toList());
		for (var info : infos.values()) {
			info.setIndexPossibles(IntStream.rangeClosed(0, infos.keySet().size() - 1)
					.boxed().collect(Collectors.toList()));
		}
		reduireLesPossibilites(bonsTickets);
		enDeduireLesPossibilites();
		return String
				.valueOf(infos.values().stream().filter(info -> info.getId().contains("departure")).mapToLong(info -> vous.getChamps().get(info.getIndexPossibles().get(0)))
						.reduce(1, (a, b) -> a * b));
	}

	private void reduireLesPossibilites(List<Ticket> bonsTickets) {
		for (Ticket ticket : bonsTickets) {
			for (int i = 0; i < ticket.getChamps().size(); i++) {
				var champ = ticket.getChamps().get(i);
				for (var info : infos.values()) {
					if ((champ < info.getMin1() || champ > info.getMax1()) && (champ < info.getMin2() || champ > info.getMax2())) {
						info.getIndexPossibles().remove(Integer.valueOf(i));
					}
				}
			}
		}
	}

	private void enDeduireLesPossibilites() {
		for (int i = 0; i < infos.keySet().size(); i++) {
			for (var info : infos.values()) {
				if (info.getIndexPossibles().size() == 1) {
					for (var info2 : infos.values()) {
						if (info != info2) {
							info2.getIndexPossibles().remove(info.getIndexPossibles().get(0));
						}
					}
				}
			}
		}
	}

}
