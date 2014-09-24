package computer;

public class LongWord extends Word {
	private long value;

	public LongWord(long value) {
		this.value = value;
	}

	LongWord() {
	}

	@Override
	public void add(Word w1, Word w2) {

		value = ((LongWord) w1).value + ((LongWord) w2).value;

	}

	@Override
	public void mul(Word w1, Word w2) {
		value = ((LongWord) w1).value * ((LongWord) w2).value;

	}

	@Override
	public void copy(Word w1) {
		value = ((LongWord) w1).value;

	}

	@Override
	public void print() {
		System.out.println(value);

	}

	@Override
	public String operandToString() {

		return value + "";
	}

	@Override
	public int compareTo(Word w) {
		if(value==((LongWord) w).value)
			return 0;
		else if(value>((LongWord) w).value)
			return 1;
		else
			return-1;
	}

}
