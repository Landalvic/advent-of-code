package annee.annee2018.jour16;

import java.util.Arrays;

public class Operation {

	private long[] registers;
	private int opcode;
	private OperationRunnable operation;
	private int a;
	private int b;
	private int c;
	private long[] resultatAttendu;

	public Operation(OperationRunnable operation, int a, int b, int c) {
		super();
		this.operation = operation;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Operation() {
		super();
		registers = new long[4];
		resultatAttendu = new long[4];
	}

	public OperationRunnable getOperation() {
		return operation;
	}

	public void setOperation(OperationRunnable operation) {
		this.operation = operation;
	}

	public long[] getResultatAttendu() {
		return resultatAttendu;
	}

	public void setResultatAttendu(long[] resultatAttendu) {
		this.resultatAttendu = resultatAttendu;
	}

	public long[] getRegisters() {
		return registers;
	}

	public void setRegisters(long[] registers) {
		this.registers = registers;
	}

	public int getOpcode() {
		return opcode;
	}

	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Operation [registers=" + Arrays.toString(registers) + ", opcode=" + opcode + ", a=" + a + ", b=" + b
				+ ", c=" + c + ", resultatAttendu=" + Arrays.toString(resultatAttendu) + "]";
	}

}
