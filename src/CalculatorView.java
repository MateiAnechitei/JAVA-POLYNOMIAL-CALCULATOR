import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorView extends JFrame {

	private JFrame frame = new JFrame("Polynomial Calculator");
	private JTextField userInput1 = new JTextField("", 25);
	private JTextField userInput2 = new JTextField("", 25);
	private JTextField output = new JTextField("", 25);
	private JButton addButton = new JButton("Add");
	private JButton subtractButton = new JButton("Subtract");
	private JButton multiplyButton = new JButton("Multiply");
	private JButton divideButton = new JButton("Divide");
	private JButton differentiateButton = new JButton("Differentiate");
	private JButton integrateButton = new JButton("Integrate");
	private CalculatorModel model;

	CalculatorView(CalculatorModel c_model) {
		model = c_model;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);

		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("Polynomial 1");
		panel1.add(label1);
		panel1.add(userInput1);

		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("Polynomial 2");
		panel2.add(label2);
		panel2.add(userInput2);

		JPanel panel3 = new JPanel();
		panel3.add(addButton);
		panel3.add(multiplyButton);
		panel3.add(integrateButton);
		panel3.add(subtractButton);
		panel3.add(divideButton);
		panel3.add(differentiateButton);
		panel3.setLayout(new GridLayout(2, 3));

		JPanel panel4 = new JPanel();
		JLabel result = new JLabel("Result");
		panel4.add(result);
		panel4.add(output);
		output.setEditable(false);

		JPanel panel = new JPanel();
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	void reset() {
		userInput1.setText("");
		userInput2.setText("");
		output.setText("");
	}

	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	String getUserInput1() {
		return userInput1.getText();
	}

	String getUserInput2() {
		return userInput2.getText();
	}

	void setOutput(String outputString) {
		output.setText(outputString);
	}

	void addAddListener(ActionListener mal) {
		addButton.addActionListener(mal);
	}

	void addSubtractListener(ActionListener mal) {
		subtractButton.addActionListener(mal);
	}

	void addMultiplyListener(ActionListener mal) {
		multiplyButton.addActionListener(mal);
	}

	void addDivideListener(ActionListener mal) {
		divideButton.addActionListener(mal);
	}

	void addIntegrateListener(ActionListener mal) {
		integrateButton.addActionListener(mal);
	}

	void addDifferentiateListener(ActionListener mal) {
		differentiateButton.addActionListener(mal);
	}
}
