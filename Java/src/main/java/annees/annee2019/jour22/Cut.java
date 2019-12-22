package annees.annee2019.jour22;

import java.util.List;

public class Cut implements Operation {

	private int cut;

	public Cut(int cut) {
		super();
		this.cut = cut;
	}

	public int getCut() {
		return cut;
	}

	public void setCut(int cut) {
		this.cut = cut;
	}

	@Override
	public long calcul(List<Operation> operations, int index, long taille, long monNombre) {
		long zone = (monNombre + cut + taille) % taille;
		return Operation.lancerPrecedenteOperation(operations, index, taille, zone);
	}

}
