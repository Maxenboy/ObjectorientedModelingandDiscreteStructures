package computer;

public class Address implements Operand {
	private int target;

	public Address(int target) {
		this.target = target;
	}

	public Word getWord(Memory mem) {
		return mem.getWord(target);
	}

	@Override
	public String operandToString() {
		return "[" + target + "]";

	}

}
