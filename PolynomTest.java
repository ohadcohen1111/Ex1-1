package myMath;

/*
 * ***** myTest1: *****
 * this test check the function 
 * -Polynom(convert String to Polynom)
 * - f(x)(the value of the Polynom in X = -3, 0)
 * - isZero (if the Polynom in the range of epsilon)
 * 
 * 0) 2 , isZero : false, f(0): 2.0, f(-3): 2.0 
 * 1) 2x^2+4x-5, isZero : false, f(0): -5.0, f(-3): 1.0
 * 2) -x^5-9x^4, isZero : false, f(0): 0.0, f(-3): -486.0
 * 3) 12x+4, isZero : false, f(0): 4.0, f(-3): -32.0
 * 
 * ***** myTest2: *****
 * this test check the function:
 * add polynom, substract polynom, multiply polynom
 * (0)       +/-/* (4x^1+7x-5) = 11.0x-5.0, -11.0x+5.0, 0
 * (-x-8x^6) +/-/* (x+2+2x^2)  = -8.0x^6+2.0x^2+2.0, -8.0x^6-2.0x^2-2.0x-2.0, -16.0x^8-8.0x^7-16.0x^6-2.0x^3-1.0x^2-2.0x
 * 
 * ***** myTest3: *****
 * this test check the function: 
 * equals tow polynoms:
 * "3x^3+4x-1.5x" ==  "3x^3+2.5x" ? true
 * "3x^3+2.5x" == "2x^2+4x^7+6" ? false
 * area:
 * 3x^3+2.5x: area(2, 4, 0.0001): 195.00000009044166, area(-3, 1, 0.0008): 69.99560015770359
 * 2x^2+4x^7+6:  area(2, 4, 0.0001): 32689.333427627847, area(-3, 1, 0.0008): 3237.324809364953
 * root:
 * 3x^3+2.5x: root(-2,2 , 0.01) = 0
 * 2x^2+4x^7+6: root(-2,2 , 0.01) = -1.1171875
 * derivative:
 * f(x) = 3x^3+2.5x , f'(x) = 9.0x^2+2.5
 * f(x) = 2x^2+4x^7+6 , f'(x) = 28.0x^6+4.0x

 * @author Ohad And Amit
 *
 */
public class PolynomTest {
	public static void main(String[] args) {
//		test1();
//		test2();
//		myTest1();
//		myTest2();
	myTest3();
		String x = "4x^2+5x";
		Polynom z = new Polynom(x);
		System.out.println(z.area(0, 2, 0.00001));
	}

	public static void myTest1() {
		System.out.println("*****  myTest1:  *****");
		String[] pol = { "2", "2x^2+4x-5", "-x^5-9x^4", "12x+4" };
		for (int i = 0; i < pol.length; i++) {
			Polynom p = new Polynom(pol[i]);
			System.out.println("Polyom: " + p + ",  f(0): " + p.f(0) + ",  f(-3): " + p.f(-3));
		}
	}

	public static void myTest2() {
		System.out.println("*****  myTest2:  *****");
		String[] pol = { "0", "4x^1+7x-5", "-x-8x^6", "x+2+2x^2" };
		System.out.println("add function:");
		for (int i = 0; i < pol.length; i += 2) {// add Polynom to Polynom
			Polynom p = new Polynom(pol[i]);
			Polynom p1 = new Polynom(pol[i + 1]);
			p.add(p1);
			System.out.println("Polynom: (" + pol[i] + ") + (" + pol[i + 1] + ") = " + p);
		}
		System.out.println();
		System.out.println("substract function: ");
		for (int i = 0; i < pol.length; i += 2) {// substract Polynom to Polynom
			Polynom p = new Polynom(pol[i]);
			Polynom p1 = new Polynom(pol[i + 1]);
			p.substract(p1);;
			System.out.println("Polynom: (" + pol[i] + ") - (" + pol[i + 1] + ") = " + p);

		}
		System.out.println();
		System.out.println("multiply function: ");

		for (int i = 0; i < pol.length; i += 2) {// multiply Polynom to Polynom
			Polynom p = new Polynom(pol[i]);
			Polynom p1 = new Polynom(pol[i + 1]);
			p.multiply(p1);
			System.out.println("Polynom: (" + pol[i] + ") * (" + pol[i + 1] + ") = " + p);

		}

	}

	public static void myTest3() {
		System.out.println("*****  myTest3:  *****");
		String[] pol = { "3x^3+4x-1.5x", "3x^3+2.5x", "2x^2+4x^7+6" };
		for (int i = 1; i < pol.length; i++) {
			Polynom p = new Polynom(pol[i - 1]);
			Polynom p1 = new Polynom(pol[i]);
			System.out.println("equals: " + pol[i] + " , " + pol[i - 1] + ": " + p.equals(p1));
		}

		for (int i = 1; i < pol.length; i++) {
			Polynom p = new Polynom(pol[i]);
			System.out.println("area: " + pol[i] + ": " + p.area(2, 4, 0.0001) + ", " + p.area(-3, 1, 0.0008));
		}
		for (int i = 1; i < pol.length; i++) {
			Polynom p = new Polynom(pol[i]);
			System.out.println("root: " + pol[i] + ": " + p.root(-2, 2, 0.01));
		}
		for (int i = 1; i < pol.length; i++) {
			Polynom p = new Polynom(pol[i]);
			System.out.println("derivative: f(x) = " + pol[i] + " , f'(x) = " + p.derivative());
		}
	}

	public static void test1() {
		System.out.println("*****  test1:  *****");
		Polynom p1 = new Polynom();
		String[] monoms = { "1", "x", "x^2", "0.5x^2" };
		for(int i=0;i<monoms.length;i++) {
		Monom m = new Monom(monoms[i]);
		p1.add(m);;
		System.out.println(p1);
	}
}

	public static void test2() {
		System.out.println("*****  test2:  *****");
		Polynom p1 = new Polynom(), p2 = new Polynom();
		String[] monoms1 = { "2", "-x", "-3.2x^2", "4", "-1.5x^2" };
		String[] monoms2 = { "5", "1.7x", "3.2x^2", "-3", "-1.5x^2" };
		for (int i = 0; i < monoms1.length; i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for (int i = 0; i < monoms2.length; i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		p1.add(p2);
		System.out.println("p1+p2: " + p1);
		p1.multiply(p2);
		System.out.println("(p1+p2)*p2: " + p1);
		String s1 = p1.toString();
		System.out.println("from string: " + p1);
	}
}
