package commands;

import computer.Address;
import computer.Operand;
import computer.Word;

public class Add extends Arithmetics {

	public Add(Operand op1, Operand op2, Address target) {
		super(op1, op2, target, "ADD");
	}

	@Override
	protected void opExecute(Word target, Word w1, Word w2) {
		target.add(w1, w2);

	}

}
