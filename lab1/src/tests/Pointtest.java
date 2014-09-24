package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Pointtest {

	@Test
	public void test() {
		Point p = new Point(10, 20);
		assertEquals(p, new Point(1, 20));
	}

}
