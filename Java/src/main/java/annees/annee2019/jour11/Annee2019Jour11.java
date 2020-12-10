package annees.annee2019.jour11;

import java.util.List;

import annees.annee2019.IntCode;
import commun.Map;
import commun.Position;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour11 extends Exercice {

	public Map<Peinture> runCommun(String input, int couleurDepart) throws AdventOfCodeException {
		var programme = FileUtils.firstLine(input);
		var code = new IntCode(programme);
		var robot = new Robot(new Position(0, 0));
		Map<Peinture> map = new Map<>();
		map.setCase(new Peinture(map, robot.getPosition(), couleurDepart));
		while (!code.isFini()) {
			List<Long> instructions = code.lancerAttendreInput((long) map.getCase(robot.getPosition()).getCouleur());
			robot.jouer(map, instructions.get(0).intValue(), instructions.get(1).intValue());
		}
		return map;
	}

}
