import java.util.*;

public class Polynomial {

	public ArrayList<Monomial> polynomial;

	public Polynomial() {
		super();
		this.polynomial = new ArrayList<Monomial>();
	}

	public ArrayList<Monomial> getPolynomial() {
		return polynomial;
	}

	public void setPolynomial(ArrayList<Monomial> polynomial) {
		this.polynomial = polynomial;
	}

	public void arrangePolynomial() {
		Collections.sort(this.polynomial, new SortByExponent());
		for (int i = 0; i < this.polynomial.size() - 1; i++) {
			if (this.polynomial.get(i).getExponent() == this.polynomial.get(i + 1).getExponent()) {
				this.polynomial.get(i + 1).setCoefficient(
						this.polynomial.get(i).getCoefficient() + this.polynomial.get(i + 1).getCoefficient());
				this.polynomial.get(i).setCoefficient(0.0f);
			}
		}
		this.polynomial.removeIf(m -> (m.getCoefficient() == 0.0));
		if (this.polynomial.isEmpty() == true) {
			Monomial m0 = new Monomial(0.0, 0);
			this.polynomial.add(m0);
		}
	}

	public void addMonomial(Monomial monomial) {
		this.polynomial.add(monomial);
	}

	public String printPolynomialDouble() {

		String result = "";
		Monomial m0 = new Monomial(0.0, 0);
		if (this.polynomial.get(0) == m0) {
			result = "0.0";
		} else {
			boolean first = true;
			for (Monomial monomial : this.polynomial) {
				if (first == true) {
					if (monomial.getCoefficient() > 0.0) {
						result = result + monomial.toStringDouble();
					} else {
						result = result + monomial.toStringDouble();
					}
					first = false;
				} else {
					if (monomial.getCoefficient() > 0.0) {
						result = result + "+" + monomial.toStringDouble();
					} else {
						result = result + monomial.toStringDouble();
					}
				}

			}
		}
		return result;
	}

	public String printPolynomialInt() {

		String result = "";
		Monomial m0 = new Monomial(0.0, 0);
		if (this.polynomial.get(0) == m0) {
			result = "0.0";
		} else {
			boolean first = true;
			for (Monomial monomial : this.polynomial) {
				if (first == true) {
					if (monomial.getCoefficient() > 0.0) {
						result = result + monomial.toStringInt();
					} else {
						result = result + monomial.toStringInt();
					}
					first = false;
				} else {
					if (monomial.getCoefficient() > 0.0) {
						result = result + "+" + monomial.toStringInt();
					} else {
						result = result + monomial.toStringInt();
					}
				}

			}
		}
		return result;
	}

	public void add(Polynomial polynomial1, Polynomial polynomial2) {
		Polynomial result = new Polynomial();
		int size1 = 0, size2 = 0;
		while (size1 != polynomial1.polynomial.size() || size2 != polynomial2.polynomial.size()) {

			if (size1 != polynomial1.polynomial.size() && size2 != polynomial2.polynomial.size()) {
				if (polynomial1.polynomial.get(size1).getExponent() > polynomial2.polynomial.get(size2).getExponent()) {
					result.addMonomial(polynomial1.polynomial.get(size1++));
				} else if (polynomial1.polynomial.get(size1).getExponent() < polynomial2.polynomial.get(size2)
						.getExponent()) {
					result.addMonomial(polynomial2.polynomial.get(size2++));
				} else {
					Monomial m = new Monomial(
							polynomial1.polynomial.get(size1).getCoefficient()
									+ polynomial2.polynomial.get(size2).getCoefficient(),
							polynomial1.polynomial.get(size1).getExponent());
					result.addMonomial(m);
					size1++;
					size2++;
				}
			} else if (size1 != polynomial1.polynomial.size()) {
				result.addMonomial(polynomial1.polynomial.get(size1));
				size1++;
			} else {
				result.addMonomial(polynomial2.polynomial.get(size2));
				size2++;
			}
		}
		result.arrangePolynomial();
		this.setPolynomial(result.polynomial);
	}

	public void subtract(Polynomial polynomial1, Polynomial polynomial2) {
		Polynomial result = new Polynomial();
		for (Monomial monomial : polynomial2.polynomial) {
			monomial.setCoefficient(-monomial.getCoefficient());
		}
		result.add(polynomial1, polynomial2);
		this.setPolynomial(result.polynomial);
	}

	public void multiply(Polynomial polynomial1, Polynomial polynomial2) {
		Polynomial result = new Polynomial();
		for (Monomial m1 : polynomial1.polynomial) {
			for (Monomial m2 : polynomial2.polynomial) {
				Monomial mn = new Monomial(m1.getCoefficient() * m2.getCoefficient(),
						m1.getExponent() + m2.getExponent());
				boolean ok = true;
				for (Monomial mr : result.polynomial) {
					if (mr.getExponent() == mn.getExponent()) {
						mr.setCoefficient(mr.getCoefficient() + mn.getCoefficient());
						ok = false;
						break;
					}

				}
				if (ok == true)
					result.addMonomial(mn);
			}
		}
		result.arrangePolynomial();
		this.setPolynomial(result.polynomial);
	}

	public Polynomial divide(Polynomial polynomial1, Polynomial polynomial2) {
		Polynomial quotient = new Polynomial();
		if (polynomial2.polynomial.get(0).getCoefficient() == 0.0f) {
			this.setPolynomial(polynomial2.polynomial);
			return polynomial2;
		} else {
			int i1 = 0;
			int i2 = 0;
			while (polynomial1.polynomial.get(i1).getExponent() >= polynomial2.polynomial.get(i2).getExponent()
					&& polynomial1.polynomial.get(0).getCoefficient() != 0.0f) {
				double coef = polynomial1.polynomial.get(i1).getCoefficient()
						/ polynomial2.polynomial.get(i2).getCoefficient();
				int exp = polynomial1.polynomial.get(i1).getExponent() - polynomial2.polynomial.get(i2).getExponent();
				Monomial m = new Monomial(coef, exp);
				quotient.addMonomial(m);
				Polynomial p = new Polynomial();
				p.addMonomial(m);
				p.multiply(polynomial2, p);
				polynomial1.subtract(polynomial1, p);
				polynomial1.arrangePolynomial();

			}
			quotient.arrangePolynomial();
			this.setPolynomial(quotient.polynomial);
			return polynomial1;
		}
	}

	public void differentiate(Polynomial polynomial1) {
		Polynomial result = new Polynomial();
		result = new Polynomial();
		for (Monomial m : polynomial1.polynomial) {
			if (m.getExponent() != 0) {
				Monomial md = new Monomial(m.getCoefficient() * m.getExponent(), m.getExponent() - 1);
				result.addMonomial(md);
			}
		}
		result.arrangePolynomial();
		this.setPolynomial(result.polynomial);
	}

	public void integrate(Polynomial polynomial1) {
		Polynomial result = new Polynomial();
		result = new Polynomial();
		for (Monomial m : polynomial1.polynomial) {
			Double d = Double.valueOf(m.getExponent()) + 1.0;
			d = m.getCoefficient() / d;
			Monomial md = new Monomial(d, m.getExponent() + 1);
			result.addMonomial(md);
		}

		result.arrangePolynomial();
		this.setPolynomial(result.polynomial);
	}

}
