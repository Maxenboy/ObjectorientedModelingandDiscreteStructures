package computer;

public class LongMemory extends Memory {
	public LongMemory(int size){
		memory= new LongWord[size];
		for(int i =0; i <size; i++){
			memory[i]= new LongWord();
		}
	}

}
