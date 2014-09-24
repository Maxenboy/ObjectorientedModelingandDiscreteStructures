package computer;

import java.util.ArrayList;

import commands.Command;

public class Program extends ArrayList<Command>{
	
	public Program() {
	}

	public String toString() {
		StringBuilder sB = new StringBuilder();
		for(Command com : this){
			sB.append(com);
			sB.append("\n");
		}
		return sB.toString();
	}
}