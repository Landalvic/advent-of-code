package annees.annee2021.jour08;

import java.util.Arrays;

public class CodeDigits {

	private String[] digits;
	private String[] output;

	public String[] getDigits() {
		return digits;
	}

	public void setDigits(String[] digits) {
		this.digits = digits;
	}

	public String[] getOutput() {
		return output;
	}

	public void setOutput(String[] output) {
		this.output = output;
	}

	@Override
	public String toString() {
		return "CodeDigits [digits=" + Arrays.toString(digits) + ", output=" + Arrays.toString(output) + "]";
	}

}
