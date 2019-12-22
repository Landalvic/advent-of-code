package annees.annee2019.jour22;

import java.util.List;

public class NewStack implements Operation {

	@Override
	public long calcul(List<Operation> operations, int index, long taille, long monNombre) {
		long zone = taille - 1 - monNombre;
		return Operation.lancerPrecedenteOperation(operations, index, taille, zone);
	}

}
