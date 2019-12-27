package annees.annee2019.jour22;

import java.util.List;

public class Cut implements Operation {

	private long cut;

	public Cut(long cut) {
		super();
		this.cut = cut;
	}

	public long getCut() {
		return cut;
	}

	public void setCut(long cut) {
		this.cut = cut;
	}

	@Override
	public long calcul(List<Operation> operations, int index, long taille, long monNombre) {
		long zone = (monNombre + cut + taille) % taille;
		return Operation.lancerPrecedenteOperation(operations, index, taille, zone);
	}

	@Override
	public long reverse(List<Operation> operations, int index, long taille, long monNombre) {
		long zone = (monNombre - cut + taille) % taille;
		return Operation.lancerPrecedenteOperation(operations, index, taille, zone);
	}

}
