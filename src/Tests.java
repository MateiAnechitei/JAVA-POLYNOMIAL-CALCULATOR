import junit.framework.*;

public class Tests extends TestCase {
	public Polynomial testPoly1 = new Polynomial();
	public Polynomial testPoly2 = new Polynomial();

	public void setUp() {
		testPoly1.addMonomial(new Monomial(1.0, 2));
		testPoly1.addMonomial(new Monomial(2.0, 1));
		testPoly1.addMonomial(new Monomial(2.0, 0));
		testPoly2.addMonomial(new Monomial(1.0, 2));
		testPoly2.addMonomial(new Monomial(2.0, 1));
		testPoly2.addMonomial(new Monomial(1.0, 0));
		
		System.out.println("setUp:");
		System.out.println(testPoly1.printPolynomialInt());
		System.out.println(testPoly2.printPolynomialInt());
	}
	
	public void testAddition() {
		Polynomial correctResult = new Polynomial();
		correctResult.addMonomial(new Monomial(2.0, 2));
		correctResult.addMonomial(new Monomial(4.0, 1));
		correctResult.addMonomial(new Monomial(3.0, 0));
		Polynomial addResult = new Polynomial();
		addResult.add(testPoly1, testPoly2);
		assertTrue(addResult.printPolynomialInt().equals(correctResult.printPolynomialInt()));
	}

	public void testSubtraction() {
		Polynomial correctResult = new Polynomial();
		correctResult.addMonomial(new Monomial(1.0, 0));
		Polynomial subtractResult = new Polynomial();
		subtractResult.subtract(testPoly1, testPoly2);
		assertTrue(subtractResult.printPolynomialInt().equals(correctResult.printPolynomialInt()));
	}

	public void testMultiplication() {
		Polynomial correctResult = new Polynomial();
		correctResult.addMonomial(new Monomial(1.0, 4));
		correctResult.addMonomial(new Monomial(4.0, 3));
		correctResult.addMonomial(new Monomial(7.0, 2));
		correctResult.addMonomial(new Monomial(6.0, 1));
		correctResult.addMonomial(new Monomial(2.0, 0));
		Polynomial multiplyResult = new Polynomial();
		multiplyResult.multiply(testPoly1, testPoly2);
		assertTrue(multiplyResult.printPolynomialInt().equals(correctResult.printPolynomialInt()));
	}

	public void testDivision() {
		Polynomial correctQuotientResult = new Polynomial();
		Polynomial correctRemainderResult = new Polynomial();
		correctQuotientResult.addMonomial(new Monomial(1.0, 0));
		correctRemainderResult.addMonomial(new Monomial(1.0, 0));
		Polynomial divideQuotientResult = new Polynomial();
		Polynomial divideRemainderResult = new Polynomial();
		divideRemainderResult = divideQuotientResult.divide(testPoly1, testPoly2);
		assertTrue(divideQuotientResult.printPolynomialDouble().equals(correctQuotientResult.printPolynomialDouble())
				&& divideRemainderResult.printPolynomialDouble()
						.equals(correctRemainderResult.printPolynomialDouble()));
	}

	public void testIntegration() {
		Polynomial correctResult = new Polynomial();
		correctResult.addMonomial(new Monomial(0.333, 3));
		correctResult.addMonomial(new Monomial(1.0, 2));
		correctResult.addMonomial(new Monomial(2.0, 1));
		Polynomial integrateResult = new Polynomial();
		integrateResult.integrate(testPoly1);
		assertTrue(integrateResult.printPolynomialDouble().equals(correctResult.printPolynomialDouble()));
	}

	public void testDifferentiation() {
		Polynomial correctResult = new Polynomial();
		correctResult.addMonomial(new Monomial(2.0, 1));
		correctResult.addMonomial(new Monomial(2.0, 0));
		Polynomial differentiateResult = new Polynomial();
		differentiateResult.differentiate(testPoly1);
		assertTrue(differentiateResult.printPolynomialInt().equals(correctResult.printPolynomialInt()));
	}
}
