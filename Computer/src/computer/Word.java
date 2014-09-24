package computer;

public abstract class Word implements Operand, Comparable<Word>{
	public abstract void add(Word w1, Word w2);
	public abstract void mul(Word w1, Word w2);
	public abstract void copy(Word w1);
	public abstract void print();
	
	public Word getWord(Memory mem){
		return this;
	}
}
