package commands;

import computer.Memory;

public interface Command {

	public int execute(Memory memory, int i);

	public String toString();
}
