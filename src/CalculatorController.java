import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

public class CalculatorController {
	private CalculatorModel cmodel;
	private CalculatorView cview;

	CalculatorController(CalculatorModel model, CalculatorView view) {
		cmodel = model;
		cview = view;
		view.addAddListener(new AddListener());
		view.addSubtractListener(new SubtractListener());
		view.addMultiplyListener(new MultiplyListener());
		view.addDivideListener(new DivideListener());
		view.addIntegrateListener(new IntegrateListener());
		view.addDifferentiateListener(new DifferentiateListener());
	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			String userInput2 = "";
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			Polynomial pr = new Polynomial();

			userInput1 = cview.getUserInput1();
			userInput1 = cmodel.checkString(userInput1);

			userInput2 = cview.getUserInput2();
			userInput2 = cmodel.checkString(userInput2);

			if (userInput1.contentEquals("Invalid input!") || userInput2.contentEquals("Invalid input!")) {
				cview.setOutput("Invalid input!");
			} else {
				p1 = cmodel.createPolynomial(userInput1);
				p2 = cmodel.createPolynomial(userInput2);
				pr.add(p1, p2);
				String result = pr.printPolynomialInt();
				cview.setOutput(result);
			}

		}
	}

	class SubtractListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			String userInput2 = "";
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			Polynomial pr = new Polynomial();

			userInput1 = cview.getUserInput1();
			userInput1 = cmodel.checkString(userInput1);

			userInput2 = cview.getUserInput2();
			userInput2 = cmodel.checkString(userInput2);

			if (userInput1.contentEquals("Invalid input!") || userInput2.contentEquals("Invalid input!")) {
				cview.setOutput("Invalid input!");
			} else {
				p1 = cmodel.createPolynomial(userInput1);
				p2 = cmodel.createPolynomial(userInput2);
				pr.subtract(p1, p2);
				String result = pr.printPolynomialInt();
				cview.setOutput(result);
			}

		}
	}

	class MultiplyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			String userInput2 = "";

			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			Polynomial pr = new Polynomial();

			userInput1 = cview.getUserInput1();
			userInput1 = cmodel.checkString(userInput1);

			userInput2 = cview.getUserInput2();
			userInput2 = cmodel.checkString(userInput2);

			if (userInput1.contentEquals("Invalid input!") || userInput2.contentEquals("Invalid input!")) {
				cview.setOutput("Invalid input!");
			} else {
				p1 = cmodel.createPolynomial(userInput1);
				p2 = cmodel.createPolynomial(userInput2);
				pr.multiply(p1, p2);
				String result = pr.printPolynomialInt();
				cview.setOutput(result);
			}

		}
	}

	class DivideListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			String userInput2 = "";

			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			Polynomial pc = new Polynomial();
			Polynomial pr = new Polynomial();

			userInput1 = cview.getUserInput1();
			userInput1 = cmodel.checkString(userInput1);

			userInput2 = cview.getUserInput2();
			userInput2 = cmodel.checkString(userInput2);

			if (userInput1.contentEquals("Invalid input!") || userInput2.contentEquals("Invalid input!")) {
				cview.setOutput("Invalid input!");
			} else {
				p1 = cmodel.createPolynomial(userInput1);
				p2 = cmodel.createPolynomial(userInput2);
				if (p2.polynomial.get(0).getCoefficient() == 0.0f) {
					cview.setOutput("Invalid input!");
				} else {
					pr = pc.divide(p1, p2);
					String quotient = pc.printPolynomialInt();
					String remainder = pr.printPolynomialInt();
					cview.setOutput("Q: " + quotient + "  R: " + remainder);
				}

			}

		}
	}

	class IntegrateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";

			Polynomial p1 = new Polynomial();
			Polynomial pr = new Polynomial();

			userInput1 = cview.getUserInput1();
			userInput1 = cmodel.checkString(userInput1);

			if (userInput1.contentEquals("Invalid input!")) {
				cview.setOutput("Invalid input!");
			} else {
				p1 = cmodel.createPolynomial(userInput1);
				pr.integrate(p1);
				String result = pr.printPolynomialDouble();
				cview.setOutput(result);
			}

		}
	}

	class DifferentiateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput1 = "";
			Polynomial p1 = new Polynomial();
			Polynomial pr = new Polynomial();

			userInput1 = cview.getUserInput1();
			userInput1 = cmodel.checkString(userInput1);

			if (userInput1.contentEquals("Invalid input!")) {
				cview.setOutput("Invalid input!");
			} else {
				p1 = cmodel.createPolynomial(userInput1);
				pr.differentiate(p1);
				String result = pr.printPolynomialInt();
				cview.setOutput(result);
			}
		}
	}
}
