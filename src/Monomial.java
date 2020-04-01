public class Monomial {

	private double coefficient;
	private int exponent;

	public Monomial(Double coefficient, Integer exponent) {
		super();
		this.coefficient = coefficient;
		this.exponent = exponent;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public String toStringDouble() {
		if (exponent > 1) {
			if (coefficient != 1.0 && coefficient != -1.0) {
				return String.format("%.3f", coefficient) + "x^" + exponent;
			} else if (coefficient == 1.0) {
				return "x^" + exponent;
			} else {
				return "-x^" + exponent;
			}
		} else if (exponent == 0) {
			return String.format("%.3f", coefficient);
		} else {
			if (coefficient != 1.0 && coefficient != -1.0) {
				return String.format("%.3f", coefficient) + "x";
			} else if (coefficient == 1.0) {
				return "x";
			} else {
				return "-x";
			}
		}

	}

	public String toStringInt() {
		if (exponent > 1) {
			if (coefficient != 1.0 && coefficient != -1.0) {
				return Math.round(coefficient) + "x^" + exponent;
			} else if (coefficient == 1.0) {
				return "x^" + exponent;
			} else {
				return "-x^" + exponent;
			}
		} else if (exponent == 0) {
			String s = "";
			return s + Math.round(coefficient);
		}

		else {
			if (coefficient != 1.0 && coefficient != -1.0) {
				return Math.round(coefficient) + "x";
			} else if (coefficient == 1.0) {
				return "x";
			} else {
				return "-x";
			}
		}

	}
}
