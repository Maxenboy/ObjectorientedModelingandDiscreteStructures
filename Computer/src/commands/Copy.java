package commands;

import computer.Address;
import commands.Command;
import computer.Memory;
import computer.Operand;

public class Copy implements Command {
	private Operand op1;
	private Address target;

	public Copy(Operand op1, Address target) {
		this.op1 = op1;
		this.target = target;

	}

	public int execute(Memory memory, int i) {
		target.getWord(memory).copy(op1.getWord(memory));
		return i + 1;
	}

	public String toString() {
		return "CPY "+op1.operandToString() + " " + target.operandToString();
	}
}
