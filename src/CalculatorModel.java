import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {

	private Polynomial polynomial1;
	private Polynomial polynomial2;
	private Polynomial result;
	Pattern pt1 = Pattern.compile("(-?\\b\\d+)[xX]\\^(\\d+\\b)");// cxe
	Pattern pt2 = Pattern.compile("(-?\\b\\d+)[xX](?=\\+|-|$)");// cx
	Pattern pt3 = Pattern.compile("(\\+|-|^)[xX]\\^(-?\\d+\\b)");// xe
	Pattern pt4 = Pattern.compile("(\\+|-|^)[xX](?=\\+|-|$)");// x
	Pattern pt5 = Pattern.compile("(\\+|-|^)(\\d+)(?=\\+|-|$)");// c
	Pattern check = Pattern.compile("[^-xX\\d\\^\\+]");

	public CalculatorModel() {
		reset();
	}

	public void reset() {
		polynomial1 = new Polynomial();
		polynomial2 = new Polynomial();
		result = new Polynomial();
	}

	public Polynomial getPolynomial1() {
		return polynomial1;
	}

	public void setPolynomial1(Polynomial polynomial1) {
		this.polynomial1 = polynomial1;
	}

	public Polynomial getPolynomial2() {
		return polynomial2;
	}

	public void setPolynomial2(Polynomial polynomial2) {
		this.polynomial2 = polynomial2;
	}

	public Polynomial getResult() {
		return result;
	}

	public void setResult(Polynomial result) {
		this.result = result;
	}

	public String checkString(String input) {
		input = input.replace(" ", "");
		input = input.replace("*", "");
		Matcher m = check.matcher(input);
		if (!m.find()) {
			return input;
		} else {
			return "Invalid input!";
		}
	}

	public Polynomial createPolynomial(String input) {
		Polynomial p = new Polynomial();
		Matcher m = pt1.matcher(input);
		while (m.find()) {
			p.addMonomial(new Monomial(Double.valueOf(m.group(1)), Integer.parseInt(m.group(2))));
		}
		m = pt2.matcher(input);
		while (m.find()) {
			p.addMonomial(new Monomial(Double.valueOf(m.group(1)), 1));
		}
		m = pt3.matcher(input);
		while (m.find()) {
			if (m.group(1).contentEquals("-")) {
				p.addMonomial(new Monomial(-1.0, Integer.parseInt(m.group(2))));
			} else {
				p.addMonomial(new Monomial(1.0, Integer.parseInt(m.group(2))));
			}
		}
		m = pt4.matcher(input);
		while (m.find()) {
			if (m.group(1).contentEquals("-")) {
				p.addMonomial(new Monomial(-1.0, 1));
			} else {
				p.addMonomial(new Monomial(1.0, 1));
			}
		}
		m = pt5.matcher(input);
		while (m.find()) {
			if (m.group(1).contentEquals("-")) {
				p.addMonomial(new Monomial(-Double.valueOf(m.group(2)), 0));
			} else {
				p.addMonomial(new Monomial(Double.valueOf(m.group(2)), 0));
			}
		}
		p.arrangePolynomial();
		return p;
	}
}
