package annees.annee2019;

import java.util.ArrayList;
import java.util.List;

public class IntCodeEssai {

	private int pointer;
	private int relativeBase;
	private String programme;
	private String[] blocs;
	private boolean fini;
	private boolean attenteInput;

	public IntCodeEssai(String programme) {
		super();
		this.programme = programme;
		init();
	}

	public void init() {
		pointer = 0;
		relativeBase = 0;
		var sblocs = programme.split(",");
		blocs = new String[sblocs.length + 1000];
		for (int i = 0; i < blocs.length; i++) {
			if (i < sblocs.length) {
				blocs[i] = sblocs[i];
			} else {
				blocs[i] = "0";
			}
		}
		fini = false;
		attenteInput = false;
	}

	public Long lancer() {
		return lancer(new ArrayList<>());
	}

	public Long lancer(List<Long> inputs) {
		var outputs = lancer(1, inputs);
		if (outputs.isEmpty()) {
			return null;
		} else {
			return outputs.get(0);
		}
	}

	public Long lancer(Long input) {
		List<Long> list = new ArrayList<Long>();
		list.add(input);
		return lancer(list);
	}

	public List<Long> lancer(int nbrOutputs) {
		return lancer(nbrOutputs, new ArrayList<>());
	}

	public List<Long> lancer(int nbrOutputs, List<Long> inputs) {
		return lancer(nbrOutputs, inputs, null);
	}

	public List<Long> lancer(int nbrOutputs, List<Long> inputs, Long nbrExecution) {
		int ipointer = Integer.parseInt(blocs[pointer]);
		List<Long> outputs = new ArrayList<>();
		Long etapes = 0L;
		while (!fini) {
			etapes++;
			int opcodePointer = Integer
					.parseInt(String.valueOf(ipointer).substring(Math.max(String.valueOf(ipointer).length() - 2, 0)));
			int mode1 = 0;
			if (String.valueOf(ipointer).length() >= 3) {
				mode1 = Integer.parseInt(
						"" + String.valueOf(ipointer).charAt(Math.max(2 + String.valueOf(ipointer).length() - 5, 0)));
			}
			int mode2 = 0;
			if (String.valueOf(ipointer).length() >= 4) {
				mode2 = Integer.parseInt(
						"" + String.valueOf(ipointer).charAt(Math.max(1 + String.valueOf(ipointer).length() - 5, 0)));
			}
			int mode3 = 0;
			if (String.valueOf(ipointer).length() >= 5) {
				mode3 = Integer.parseInt("" + String.valueOf(ipointer).charAt(0));
			}
			long valeur1;
			if (mode1 == 1) {
				valeur1 = Long.parseLong(blocs[pointer + 1]);
			} else if (mode1 == 2) {
				valeur1 = Long.parseLong(blocs[relativeBase + Integer.parseInt(blocs[pointer + 1])]);
			} else {
				valeur1 = Long.parseLong(blocs[Integer.parseInt(blocs[pointer + 1])]);
			}
			long valeur2 = 0;
			if (opcodePointer == 1 || opcodePointer == 2 || opcodePointer == 5 || opcodePointer == 6
					|| opcodePointer == 7 || opcodePointer == 8) {
				if (mode2 == 1) {
					valeur2 = Long.parseLong(blocs[pointer + 2]);
				} else if (mode2 == 2) {
					valeur2 = Long.parseLong(blocs[relativeBase + Integer.parseInt(blocs[pointer + 2])]);
				} else {
					valeur2 = Long.parseLong(blocs[Integer.parseInt(blocs[pointer + 2])]);
				}
			}
			if (opcodePointer == 99) {
				pointer++;
				fini = true;
				break;
			} else if (opcodePointer == 1) {
				if (mode3 == 2) {
					blocs[relativeBase + Integer.parseInt(blocs[pointer + 3])] = "" + (valeur1 + valeur2);
				} else {
					blocs[Integer.parseInt(blocs[pointer + 3])] = "" + (valeur1 + valeur2);
				}
				pointer += 4;
			} else if (opcodePointer == 2) {
				if (mode3 == 2) {
					blocs[relativeBase + Integer.parseInt(blocs[pointer + 3])] = "" + (valeur1 * valeur2);
				} else {
					blocs[Integer.parseInt(blocs[pointer + 3])] = "" + (valeur1 * valeur2);
				}
				pointer += 4;
			} else if (opcodePointer == 3) {
				if (inputs.isEmpty()) {
					attenteInput = true;
					return outputs;
				}
				if (mode1 == 2) {
					blocs[relativeBase + Integer.parseInt(blocs[pointer + 1])] = "" + inputs.remove(0);
				} else {
					blocs[Integer.parseInt(blocs[pointer + 1])] = "" + inputs.remove(0);
				}
				pointer += 2;
			} else if (opcodePointer == 4) {
				outputs.add(valeur1);
				pointer += 2;
				if (outputs.size() == nbrOutputs) {
					return outputs;
				}
			} else if (opcodePointer == 5) {
				if (valeur1 != 0) {
					pointer = (int) valeur2;
				} else {
					pointer += 3;
				}
			} else if (opcodePointer == 6) {
				if (valeur1 == 0) {
					pointer = (int) valeur2;
				} else {
					pointer += 3;
				}
			} else if (opcodePointer == 7) {
				if (valeur1 < valeur2) {
					if (mode3 == 2) {
						blocs[relativeBase + Integer.parseInt(blocs[pointer + 3])] = "1";
					} else {
						blocs[Integer.parseInt(blocs[pointer + 3])] = "1";
					}
				} else {
					if (mode3 == 2) {
						blocs[relativeBase + Integer.parseInt(blocs[pointer + 3])] = "0";
					} else {
						blocs[Integer.parseInt(blocs[pointer + 3])] = "0";
					}
				}
				pointer += 4;
			} else if (opcodePointer == 8) {
				if (valeur1 == valeur2) {
					if (mode3 == 2) {
						blocs[relativeBase + Integer.parseInt(blocs[pointer + 3])] = "1";
					} else {
						blocs[Integer.parseInt(blocs[pointer + 3])] = "1";
					}
				} else {
					if (mode3 == 2) {
						blocs[relativeBase + Integer.parseInt(blocs[pointer + 3])] = "0";
					} else {
						blocs[Integer.parseInt(blocs[pointer + 3])] = "0";
					}
				}
				pointer += 4;
			} else if (opcodePointer == 9) {
				relativeBase += (int) valeur1;
				pointer += 2;
			} else {
				pointer += 1;
			}
			ipointer = Integer.parseInt(blocs[pointer]);
			if (nbrExecution != null && etapes == nbrExecution.longValue()) {
				return outputs;
			}
		}
		return outputs;
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

}
