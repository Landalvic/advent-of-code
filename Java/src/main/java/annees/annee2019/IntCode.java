package annees.annee2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntCode implements Comparable<IntCode> {

	private int pointer;
	private int relativeBase;
	private long nbrEtape;
	private String programme;
	private String[] blocs;
	private boolean fini;
	private int adresse;

	public IntCode(String programme) {
		super();
		this.programme = programme;
		init();
	}

	public IntCode(IntCode code) {
		super();
		pointer = code.pointer;
		relativeBase = code.relativeBase;
		nbrEtape = code.nbrEtape;
		programme = code.programme;
		blocs = Arrays.copyOf(code.blocs, code.blocs.length);
		fini = code.fini;
		adresse = code.adresse;
	}

	public void init() {
		pointer = 0;
		relativeBase = 0;
		nbrEtape = 0;
		blocs = programme.split(",");
		fini = false;
	}

	public int getAdresse() {
		return adresse;
	}

	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}

	public long getNbrEtape() {
		return nbrEtape;
	}

	public void setNbrEtape(long nbrEtape) {
		this.nbrEtape = nbrEtape;
	}

	public String getBloc(int index) {
		if (blocs.length > index) {
			return blocs[index];
		} else {
			return "0";
		}
	}

	public void setBloc(int index, String value) {
		if (blocs.length <= index) {
			int ancienneTaille = blocs.length;
			blocs = Arrays.copyOf(blocs, index + 1);
			for (int i = ancienneTaille; i < blocs.length; i++) {
				blocs[i] = "0";
			}
		}
		blocs[index] = value;
	}

	public int getPointer() {
		return pointer;
	}

	public void setPointer(int pointer) {
		this.pointer = pointer;
	}

	public int getRelativeBase() {
		return relativeBase;
	}

	public void setRelativeBase(int relativeBase) {
		this.relativeBase = relativeBase;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public String[] getBlocs() {
		return blocs;
	}

	public void setBlocs(String[] blocs) {
		this.blocs = blocs;
	}

	public boolean isFini() {
		return fini;
	}

	public void setFini(boolean fini) {
		this.fini = fini;
	}

	public List<Long> ecrireAscii(String texte) {
		List<Long> inputs = new ArrayList<>();
		for (int i = 0; i < texte.length(); i++) {
			inputs.add((long) texte.charAt(i));
		}
		return inputs;
	}

	public String lireAscii(List<Long> outputs) {
		StringBuilder s = new StringBuilder();
		for (Long long1 : outputs) {
			s.append(Character.toString((char) long1.intValue()));
		}
		return s.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((programme == null) ? 0 : programme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		IntCode other = (IntCode) obj;
		if (programme == null) {
			if (other.programme != null) {
				return false;
			}
		} else if (!programme.equals(other.programme)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(IntCode o) {
		return Long.compare(nbrEtape, o.nbrEtape);
	}

	public List<Long> lancerAttendreInput() {
		return lancer(Integer.MAX_VALUE, new ArrayList<>());
	}

	public List<Long> lancerAttendreInput(Long input) {
		return lancerAttendreInput(Arrays.asList(input));
	}

	public List<Long> lancerAttendreInput(List<Long> inputs) {
		return lancer(Integer.MAX_VALUE, inputs);
	}

	public Long lancerFirstOutput() {
		return lancerFirstOutput(new ArrayList<Long>());
	}

	public Long lancerFirstOutput(Long input) {
		return lancerFirstOutput(Arrays.asList(input));
	}

	public Long lancerFirstOutput(List<Long> inputs) {
		var outputs = lancer(1, inputs);
		if (outputs.isEmpty()) {
			return null;
		} else {
			return outputs.get(0);
		}
	}

	public List<Long> lancer() {
		return lancer(new ArrayList<>());
	}

	public List<Long> lancer(List<Long> inputs) {
		return lancer(1, inputs);
	}

	public List<Long> lancer(Long input) {
		return lancer(Arrays.asList(input));
	}

	public List<Long> lancer(int nbrOutputs, Long input) {
		return lancer(nbrOutputs, Arrays.asList(input));
	}

	public List<Long> lancer(int nbrOutputs) {
		return lancer(nbrOutputs, new ArrayList<>());
	}

	public List<Long> lancer(int nbrOutputs, List<Long> inputs) {
		inputs = new ArrayList<>(inputs);
		int ipointer = Integer.parseInt(getBloc(pointer));
		List<Long> outputs = new ArrayList<>();
		while (!fini) {
			nbrEtape++;
			int opcodePointer = Integer.parseInt(String.valueOf(ipointer).substring(Math.max(String.valueOf(ipointer).length() - 2, 0)));
			int mode1 = calculerMode1(ipointer);
			int mode2 = calculerMode2(ipointer);
			int mode3 = calculerMode3(ipointer);
			long valeur1 = calculerValeur1(mode1);
			long valeur2 = calculerValeur2(opcodePointer, mode2);
			switch (opcodePointer) {
			case 1:
				intCode1(valeur1, valeur2, mode3);
				break;
			case 2:
				intCode2(valeur1, valeur2, mode3);
				break;
			case 3:
				if (inputs.isEmpty()) {
					return outputs;
				}
				intCode3(inputs, mode1);
				break;
			case 4:
				intCode4(outputs, valeur1);
				if (outputs.size() == nbrOutputs) {
					return outputs;
				}
				break;
			case 5:
				intCode5(valeur1, valeur2);
				break;
			case 6:
				intCode6(valeur1, valeur2);
				break;
			case 7:
				intCode7(valeur1, valeur2, mode3);
				break;
			case 8:
				intCode8(valeur1, valeur2, mode3);
				break;
			case 9:
				intCode9(valeur1);
				break;
			case 99:
				intCode99();
				break;
			default:
				pointer += 1;
				break;
			}
			ipointer = Integer.parseInt(getBloc(pointer));
		}
		return outputs;
	}

	private void intCode1(long valeur1, long valeur2, int mode3) {
		if (mode3 == 2) {
			setBloc(relativeBase + Integer.parseInt(getBloc(pointer + 3)), String.valueOf(valeur1 + valeur2));
		} else {
			setBloc(Integer.parseInt(getBloc(pointer + 3)), String.valueOf(valeur1 + valeur2));
		}
		pointer += 4;
	}

	private void intCode2(long valeur1, long valeur2, int mode3) {
		if (mode3 == 2) {
			setBloc(relativeBase + Integer.parseInt(getBloc(pointer + 3)), String.valueOf(valeur1 * valeur2));
		} else {
			setBloc(Integer.parseInt(getBloc(pointer + 3)), String.valueOf(valeur1 * valeur2));
		}
		pointer += 4;
	}

	private void intCode3(List<Long> inputs, int mode1) {
		if (mode1 == 2) {
			setBloc(relativeBase + Integer.parseInt(getBloc(pointer + 1)), String.valueOf(inputs.remove(0)));
		} else {
			setBloc(Integer.parseInt(getBloc(pointer + 1)), String.valueOf(inputs.remove(0)));
		}
		pointer += 2;
	}

	private void intCode4(List<Long> outputs, long valeur1) {
		outputs.add(valeur1);
		pointer += 2;
	}

	private void intCode5(long valeur1, long valeur2) {
		if (valeur1 != 0) {
			pointer = (int) valeur2;
		} else {
			pointer += 3;
		}
	}

	private void intCode6(long valeur1, long valeur2) {
		if (valeur1 == 0) {
			pointer = (int) valeur2;
		} else {
			pointer += 3;
		}
	}

	private void intCode7(long valeur1, long valeur2, int mode3) {
		if (valeur1 < valeur2) {
			if (mode3 == 2) {
				setBloc(relativeBase + Integer.parseInt(getBloc(pointer + 3)), "1");
			} else {
				setBloc(Integer.parseInt(getBloc(pointer + 3)), "1");
			}
		} else {
			if (mode3 == 2) {
				setBloc(relativeBase + Integer.parseInt(getBloc(pointer + 3)), "0");
			} else {
				setBloc(Integer.parseInt(getBloc(pointer + 3)), "0");
			}
		}
		pointer += 4;
	}

	private void intCode8(long valeur1, long valeur2, int mode3) {
		if (valeur1 == valeur2) {
			if (mode3 == 2) {
				setBloc(relativeBase + Integer.parseInt(getBloc(pointer + 3)), "1");
			} else {
				setBloc(Integer.parseInt(getBloc(pointer + 3)), "1");
			}
		} else {
			if (mode3 == 2) {
				setBloc(relativeBase + Integer.parseInt(getBloc(pointer + 3)), "0");
			} else {
				setBloc(Integer.parseInt(getBloc(pointer + 3)), "0");
			}
		}
		pointer += 4;
	}

	private void intCode9(long valeur1) {
		relativeBase += (int) valeur1;
		pointer += 2;
	}

	private void intCode99() {
		pointer++;
		fini = true;
	}

	private int calculerMode1(int ipointer) {
		if (String.valueOf(ipointer).length() >= 3) {
			return Integer.parseInt(String.valueOf(String.valueOf(ipointer).charAt(Math.max(2 + String.valueOf(ipointer).length() - 5, 0))));
		}
		return 0;
	}

	private int calculerMode2(int ipointer) {
		if (String.valueOf(ipointer).length() >= 4) {
			return Integer.parseInt(String.valueOf(String.valueOf(ipointer).charAt(Math.max(1 + String.valueOf(ipointer).length() - 5, 0))));
		}
		return 0;
	}

	private int calculerMode3(int ipointer) {
		if (String.valueOf(ipointer).length() >= 5) {
			return Integer.parseInt(String.valueOf(String.valueOf(ipointer).charAt(0)));
		}
		return 0;
	}

	private long calculerValeur1(int mode1) {
		if (mode1 == 1) {
			return Long.parseLong(getBloc(pointer + 1));
		} else if (mode1 == 2) {
			return Long.parseLong(getBloc(relativeBase + Integer.parseInt(getBloc(pointer + 1))));
		} else {
			return Long.parseLong(getBloc(Integer.parseInt(getBloc(pointer + 1))));
		}
	}

	private long calculerValeur2(int opcodePointer, int mode2) {
		if (opcodePointer == 1 || opcodePointer == 2 || opcodePointer == 5 || opcodePointer == 6 || opcodePointer == 7 || opcodePointer == 8) {
			if (mode2 == 1) {
				return Long.parseLong(getBloc(pointer + 2));
			} else if (mode2 == 2) {
				return Long.parseLong(getBloc(relativeBase + Integer.parseInt(getBloc(pointer + 2))));
			} else {
				return Long.parseLong(getBloc(Integer.parseInt(getBloc(pointer + 2))));
			}
		}
		return 0;
	}

}
