package annee.annee2018.jour16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class OperationRunnable {

	private List<Integer> idsPossibles = new ArrayList<>(
			Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));

	public abstract long[] run(Operation operation);

	public abstract String getId();

	public List<Integer> getIdsPossibles() {
		return idsPossibles;
	}

	public void setIdsPossibles(List<Integer> idsPossibles) {
		this.idsPossibles = idsPossibles;
	}

}
