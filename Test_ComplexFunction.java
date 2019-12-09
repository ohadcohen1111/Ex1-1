package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_ComplexFunction {

	@Test
	void testComplexFunctionOperationFunctionFunction() {
		String[] ComplexFunc = { "plus(min(x,plus(4x+5,-2x)),x^4+3)", "mul(2x,min(3x^3,5x-9))",
				"max(x^2,plus(4x+5,div(x,3)))" };
		// String a = "plus(min(x,plus(4x+5,-2x)),x^4+3)";
		// String b = "mul(2x,min(3x^3,5x-9))";
		// String c = "max(x^2,plus(4x+5,div(x,3)),2x+3)";
		String[] expected = { "plus(min(1.0x,plus(4.0x+5.0,-2.0x)),1.0x^4+3.0)", "times(2.0x,min(3.0x^3,5.0x-9.0))",
				"max(1.0x^2,plus(4.0x+5.0,divid(1.0x,3.0)))" };
		for (int i = 0; i < ComplexFunc.length; i++) {
			ComplexFunction cf = new ComplexFunction();
			function f = cf.initFromString(ComplexFunc[i]);
			assertEquals(f.toString().toLowerCase(), expected[i].toLowerCase());
		}

	}

	@Test
	void testComplexFunctionStringFunctionFunction() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexFunctionFunction() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexFunction() {
		fail("Not yet implemented");
	}

	@Test
	void testInitFromString() {
		fail("Not yet implemented");
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	void testPlus() {
		fail("Not yet implemented");
	}

	@Test
	void testMul() {
		fail("Not yet implemented");
	}

	@Test
	void testDiv() {
		fail("Not yet implemented");
	}

	@Test
	void testMax() {
		fail("Not yet implemented");
	}

	@Test
	void testMin() {
		fail("Not yet implemented");
	}

	@Test
	void testComp() {
		fail("Not yet implemented");
	}

	@Test
	void testLeft() {
		fail("Not yet implemented");
	}

	@Test
	void testRight() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOp() {
		fail("Not yet implemented");
	}

}
