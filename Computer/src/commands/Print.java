package commands;

import computer.Address;
import commands.Command;
import computer.Memory;

public class Print implements Command {
	private Address target;

	public Print(Address target) {
		this.target = target;
	}

	public int execute(Memory memory, int i) {
		target.getWord(memory).print();
		return i + 1;
	}

	public String toString() {
		return "PRT "+target.operandToString();
	}

}
