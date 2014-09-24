package commands;

import computer.Memory;
import computer.Operand;

public class JumpEq extends Jump {
	private Operand op1, op2;

	public JumpEq(int target, Operand op1, Operand op2) {
		super(target);
		this.op1 = op1;
		this.op2 = op2;
	}

	public int execute(Memory mem, int next) {
		if (op1.getWord(mem).compareTo(op2.getWord(mem)) == 0)
			return target;
		else
			return next + 1;
	}

	public String toString() {
		StringBuilder sB = new StringBuilder();
		sB.append("JEQ ");
		sB.append(target);
		sB.append(" ");
		sB.append(op1.operandToString());
		sB.append(" ");
		sB.append(op2.operandToString());
		return sB.toString();
	}
}
