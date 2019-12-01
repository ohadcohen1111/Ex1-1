package myMath;

import java.util.ArrayList;

/**
 * This class represents a simple (naive) tester for the Monom class, Note: <br>
 * (i) The class is NOT a JUNIT - (i.e., educational reasons) - should be
 * changed to a proper JUnit in Ex1. <br>
 * (ii) This tester should be extend in order to test ALL the methods and
 * functionality of the Monom class. <br>
 * (iii) Expected output: <br>
 * ***** Test1: ***** <br>
 * 0) 2.0 isZero: false f(0) = 2.0 <br>
 * 1) -1.0x isZero: false f(1) = -1.0 <br>
 * 2) -3.2x^2 isZero: false f(2) = -12.8 <br>
 * 3) 0 isZero: true f(3) = 0.0 <br>
 ***** Test2: ***** <br>
 * 0) 0 isZero: true eq: true <br>
 * 1) -1.0 isZero: false eq: true <br>
 * 2) -1.3x isZero: false eq: true <br>
 * 3) -2.2x^2 isZero: false eq: true <br>
 * 
 * *****test3***** *
 * this test check the function: add Monom, substract Monom,
 * multiply Monom   
 * 1) (-3x^7)+/-/*(8x^7) = -24.0x^14, 5.0x^7, -11.0x^7
 * 2) (0.68x^3)+/-/*(1.9x^3) =  1.292x^6, 2.58x^3, -1.2199999999999998x^3
 * 3) (0)+/-/*(-x) = 0, not accepted, not accepted
 * 4) (4.9x)+/-/*(3x^2) =14.700000000000001x^3, not accepted, not accepted
 */
public class MonomTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}


	private static void test1() {
		System.out.println("*****  Test1:  *****");
		String[] monoms = { "2", "-x", "-3.2x^2", "0" };
		for (int i = 0; i < monoms.length; i++) {
			Monom m = new Monom(monoms[i]);
			String s = m.toString();
			m = new Monom(s);
			double fx = m.f(i);
			System.out.println(i + ") " + m + "    \tisZero: " + m.isZero() + "\t f(" + i + ") = " + fx);
		}
	}

	private static void test2() {
		System.out.println("*****  Test2:  *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(0, 5));
		monoms.add(new Monom(-1, 0));
		monoms.add(new Monom(-1.3, 1));
		monoms.add(new Monom(-2.2, 2));

		for (int i = 0; i < monoms.size(); i++) {
			Monom m = new Monom(monoms.get(i));
			String s = m.toString();
			Monom m1 = new Monom(s);
			boolean e = m.equals(m1);
			System.out.println(i + ") " + m + "    \tisZero: " + m.isZero() + "  \teq: " + e);
		}
	}
	
	
	private static void test3() {
		System.out.println("*****  Test3:  *****");
		String[] Monom = { "-3x^7", "8x^7", "0.68x^3", "1.9x^3","0", "-x", "4.9x", "3x^2"};
		
		for (int i = 0; i < Monom.length; i += 2) {
			Monom m = new Monom(Monom[i]);
			Monom m1 = new Monom(Monom[i + 1]);
			m.multipy(m1);
			System.out.println("multiply: (" + Monom[i] + ")*(" + Monom[i + 1] + ")= " + m);
		}
		for (int i = 0; i < Monom.length; i += 2) {
			try {
				Monom m = new Monom(Monom[i]);
				Monom m1 = new Monom(Monom[i + 1]);
				m.add(m1);
				System.out.println("add: (" + Monom[i] + ")+(" + Monom[i + 1] + ")= " + m);
			} catch (Exception e) {
				throw new InvalidInputException("Invalid Input");
			}
		}
		for (int i = 0; i < Monom.length; i += 2) {
			try {
			Monom m = new Monom(Monom[i]);
			Monom m1 = new Monom(Monom[i + 1]);
			m.substract(m1);
			System.out.println("substract: (" + Monom[i] + ")-(" + Monom[i + 1] + ")= " + m);
		}catch (Exception e) {
			throw new InvalidInputException("Invalid Input");
		}
		
	}

	}
	}
