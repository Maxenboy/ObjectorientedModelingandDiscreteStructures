package computer;

public class Computer {
	private Memory mem;
	private ProgramCounter pC;
	private Program prog;

	public Computer(Memory mem) {
		this.mem = mem;
		pC = new ProgramCounter();
	}

	public void load(Program prog) {
		this.prog = prog;
	}

	public void run() {
		int next = 0;

		while (next >= 0) {
			next = pC.getNextLineNumber();
			next = prog.get(next).execute(mem, next);
			pC.jumpToLine(next);
		}
	}
}
