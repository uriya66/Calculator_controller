import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

public class Calculator_controller {

	@FXML
	private TextField txt_result;

	@FXML
	private Button division_button, equal_button, minus_button, multiplication_button, plus_button;

	@FXML
	private Button dot_button, negative_button, ac_button;

	@FXML
	private Button one, two, three, four, five, six, seven, eight, nine;

	String op = "";
	String operation = "";
	double number1;
	double number2;
	boolean bool = false;
	
	// Resets the calculator
	@FXML
	void ac_pressed(ActionEvent event) {
		txt_result.setText ("");
	}

	// Adds a decimal point to the number
	@FXML
	void dot_pressed(ActionEvent event) {
		String dot1 , dot2;
		if(operation.equals(".")) {
            JOptionPane.showMessageDialog(null, "You can click '.' only ones.","Bad Operation",JOptionPane.ERROR_MESSAGE);
		}else {
		operation = ((Button)event.getSource()).getText();
		dot1 = txt_result.getText();
		dot2 = dot1 + operation;
		txt_result.setText (dot2);
		}
	}

	// Click to change number to negative or positive 
	@FXML
	void negative_pressed(ActionEvent event) {
		double plusMinus = Double.parseDouble(String.valueOf(txt_result.getText()));
		plusMinus = plusMinus * (-1);
		txt_result.setText(String.valueOf(plusMinus));
	}

	// click to add numbers
	@FXML
	void number_pressed(ActionEvent event) {
		if (!txt_result.getText().equals("") && bool == true) {
			txt_result.setText ("");
			bool = false;
		}
		if (txt_result.getText().equals("ERROR")) {
			txt_result.setText ("");
		}
		String num = ((Button)event.getSource()).getText();
		txt_result.setText(txt_result.getText() + num);	
	}

	//click for operation
	@FXML
	void operation_pressed(ActionEvent event) {
		operation = ((Button)event.getSource()).getText();
		if(!operation.equals("=")) {
			if(!op.equals("")) {
				return;
			}
			op = operation;
			number1 = Double.parseDouble(txt_result.getText());
			txt_result.setText("");
		}else {
			if(op.equals("")) {
				return;
			}
			number2 = Double.parseDouble(txt_result.getText());

			System.out.println(number1);
			System.out.println(number2);

			calculate(number1, number2, op);
			op="";
			bool = true;
			}
	}

	//calculate method
	private void calculate(double num1, double num2, String op) {
		switch(op) {
		case "/" : 
			if(num2 == 0) {
				txt_result.setText ("ERROR");
				JOptionPane.showMessageDialog(null, "You can not divide by 0.","Bad Operation",JOptionPane.ERROR_MESSAGE);
				break; 
			}else {
				txt_result.setText (num1 / num2 + ""); break;
			} 
		case "-" : txt_result.setText (num1 - num2 + ""); break;
		case "*" : txt_result.setText (num1 * num2 + ""); break;
		case "+" : txt_result.setText (num1 + num2 + ""); break;
        default:
		}
	}
}
