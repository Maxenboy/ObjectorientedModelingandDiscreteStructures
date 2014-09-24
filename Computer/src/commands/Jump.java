package commands;

import computer.Memory;

public class Jump implements Command {
	protected int target;

	public Jump(int target) {
		this.target = target;
	}

	public int execute(Memory mem, int next) {
		return target;
	}

	public String toString() {
		return "JMP " + target;
	}
}