package computer;

public class ProgramCounter {

	private int nextLine;
	
	public ProgramCounter(){
		nextLine = 0;
	}

	int getNextLineNumber() {
		return nextLine;
	}

	void jumpToLine(int line) {
		nextLine = line;
	}

}