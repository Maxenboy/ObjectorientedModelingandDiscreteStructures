package commands;

import computer.Address;
import computer.Operand;
import computer.Word;

public class Mul extends Arithmetics {

	public Mul(Operand op1, Operand op2, Address target) {
		super(op1, op2, target, "MUL");
	}

	@Override
	protected void opExecute(Word target, Word w1, Word w2) {
		target.mul(w1, w2);

	}

}
