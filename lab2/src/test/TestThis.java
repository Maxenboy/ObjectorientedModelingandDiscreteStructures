package test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Satslogik.Conjunction;
import Satslogik.Disjunction;
import Satslogik.Equivalent;
import Satslogik.Expr;
import Satslogik.Implication;
import Satslogik.Negate;
import Satslogik.Variable;

public class TestThis extends TestCase {
	private Variable a, b, c;

	@Before
	public void setUp() {
		a = new Variable("a");
		b = new Variable("b");
		c = new Variable("c");
	}

	@Test
	public void testDoubleNegate() {
		Expr e = new Negate(a);
		Expr e1 = new Negate(e);
		Expr e2 = new Equivalent(a, e1);
		assertTrue(e2.isTautology());
	}

	@Test
	public void testComplexTautology1() {
		Expr and1 = new Conjunction(b, c);
		Expr impl1 = new Implication(a, and1);
		Expr impl2 = new Implication(a, b);
		Expr impl3 = new Implication(a, c);
		Expr and2 = new Conjunction(impl2, impl3);
		Expr allt = new Equivalent(impl1, and2);
		assertTrue(allt.isTautology());
	}

	@Test
	public void testNotComplexTautology2() {
		Expr and1 = new Conjunction(a, b);
		Expr impl1 = new Implication(and1, c);
		Expr impl2 = new Implication(a, c);
		Expr impl3 = new Implication(a, b);
		Expr and2 = new Conjunction(impl2, impl3);
		Expr allt = new Equivalent(impl1, and2);
		assertFalse(allt.isTautology());
	}

	@Test
	public void testIsTautologySimple1() {
		Expr e = new Disjunction(a, new Negate(a));
		assertTrue(e.isTautology());
	}

	@Test
	public void testNotTautology() {
		Expr e = new Conjunction(a, b);
		assertTrue(!e.isTautology());
	}

	@After
	public void tearDown() {
		a = null;
		b = null;
		c = null;
	}
}
