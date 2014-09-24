package computer;


public abstract class Memory {
	protected Word[] memory;

	public Word getWord(int location) {
		return memory[location];
	}
}
