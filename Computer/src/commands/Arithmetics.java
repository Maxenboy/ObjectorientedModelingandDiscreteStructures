package commands;

import computer.Address;
import computer.Memory;
import computer.Word;
import commands.Command;
import computer.Operand;

public abstract class Arithmetics implements Command {
	private Operand op1, op2;
	private Address target;
	private String operationName;

	protected Arithmetics(Operand op1, Operand op2, Address target,
			String opName) {
		this.op1 = op1;
		this.op2 = op2;
		this.target = target;
		operationName = opName;

	}

	public int execute(Memory memory, int i) {

		opExecute(target.getWord(memory), op1.getWord(memory),
				op2.getWord(memory));

		return i + 1;
	}

	protected abstract void opExecute(Word target, Word w1, Word w2);

	public String toString() {
		return operationName + op1.operandToString() + " "
				+ op2.operandToString() + " " + target.operandToString();
	}
}
