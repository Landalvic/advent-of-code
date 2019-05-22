package annees.annee2015.jour16;

public class TanteSue {

	private Integer numero;
	private Integer enfants;
	private Integer chats;
	private Integer samoyedes;
	private Integer pomeraniens;
	private Integer akitas;
	private Integer vizslas;
	private Integer poissonsRouges;
	private Integer arbres;
	private Integer voitures;
	private Integer parfums;

	public TanteSue(Integer numero, Integer enfants, Integer chats, Integer samoyedes, Integer pomeraniens,
			Integer akitas, Integer vizslas, Integer poissonsRouges, Integer arbres, Integer voitures,
			Integer parfums) {
		super();
		this.numero = numero;
		this.enfants = enfants;
		this.chats = chats;
		this.samoyedes = samoyedes;
		this.pomeraniens = pomeraniens;
		this.akitas = akitas;
		this.vizslas = vizslas;
		this.poissonsRouges = poissonsRouges;
		this.arbres = arbres;
		this.voitures = voitures;
		this.parfums = parfums;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getEnfants() {
		return enfants;
	}

	public void setEnfants(Integer enfants) {
		this.enfants = enfants;
	}

	public Integer getChats() {
		return chats;
	}

	public void setChats(Integer chats) {
		this.chats = chats;
	}

	public Integer getSamoyedes() {
		return samoyedes;
	}

	public void setSamoyedes(Integer samoyedes) {
		this.samoyedes = samoyedes;
	}

	public Integer getPomeraniens() {
		return pomeraniens;
	}

	public void setPomeraniens(Integer pomeraniens) {
		this.pomeraniens = pomeraniens;
	}

	public Integer getAkitas() {
		return akitas;
	}

	public void setAkitas(Integer akitas) {
		this.akitas = akitas;
	}

	public Integer getVizslas() {
		return vizslas;
	}

	public void setVizslas(Integer vizslas) {
		this.vizslas = vizslas;
	}

	public Integer getPoissonsRouges() {
		return poissonsRouges;
	}

	public void setPoissonsRouges(Integer poissonsRouges) {
		this.poissonsRouges = poissonsRouges;
	}

	public Integer getArbres() {
		return arbres;
	}

	public void setArbres(Integer arbres) {
		this.arbres = arbres;
	}

	public Integer getVoitures() {
		return voitures;
	}

	public void setVoitures(Integer voitures) {
		this.voitures = voitures;
	}

	public Integer getParfums() {
		return parfums;
	}

	public void setParfums(Integer parfums) {
		this.parfums = parfums;
	}

	@Override
	public String toString() {
		return "TanteSue [numero=" + numero + ", enfants=" + enfants + ", chats=" + chats + ", samoyedes=" + samoyedes
				+ ", pomeraniens=" + pomeraniens + ", akitas=" + akitas + ", vizslas=" + vizslas + ", poissonsRouges="
				+ poissonsRouges + ", arbres=" + arbres + ", voitures=" + voitures + ", parfums=" + parfums + "]";
	}
}
