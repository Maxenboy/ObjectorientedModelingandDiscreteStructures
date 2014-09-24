package commands;

import commands.Command;
import computer.Memory;

public class Halt implements Command {

	public Halt() {

	}

	public int execute(Memory memory, int i) {
		return -1;

	}

	public String toString() {
		return "HLT";
	}

}
