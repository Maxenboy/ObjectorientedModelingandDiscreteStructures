package test;

import computer.Computer;
import computer.LongMemory;
import computer.Program;

public class Test {

	public static void main(String[] args) {

		Program factorial = new Factorial();
		System.out.println(factorial);
		Computer computer = new Computer(new LongMemory(64));
		computer.load(factorial);
		computer.run();
	}
}
