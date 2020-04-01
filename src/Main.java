public class Main {

	public static void main(String[] args) {

		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView(model);
		CalculatorController cont = new CalculatorController(model, view);
	}

}
