package annees.annee2019.jour22;

import java.util.List;

public interface Operation {

	static long lancerPrecedenteOperation(List<Operation> operations, int index, long taille, long monNombre) {
		if (index > 0) {
			return operations.get(index - 1).calcul(operations, index - 1, taille, monNombre);
		} else {
			return monNombre;
		}
	}

	long calcul(List<Operation> operations, int index, long taille, long monNombre);

}
