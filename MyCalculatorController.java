package application;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class MyCalculatorController implements Initializable{
	
	public BigDecimal inputNum;
	public double num1;
	public double num2;
	public String operator = "";
	public Boolean newNumber = false;
	public Boolean decimal = false;
	public String memory = "";
	
    @FXML
    private Button equalButton;

    @FXML
    private Button subButton;

    @FXML
    private Button ceButton;

    @FXML
    private Button plusMinusButton;

    @FXML
    private Button addButton;

    @FXML
    private Button mButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button decButton;

    @FXML
    private Button eightButton;

    @FXML
    private TextField inputDisplay;

    @FXML
    private Button mcButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button mrButton;

    @FXML
    private Button cButton;

    @FXML
    private Button zeroButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button divButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button fiveButton;

    public MyCalculatorController() {
    	this.inputNum = BigDecimal.ZERO;
    	this.operator = "";
    }
    
    // events to handle when buttons are clicked
    @FXML
    public void numButton(ActionEvent evt) {
    	Button button = (Button) evt.getSource();
    	String buttonText = button.getText();
    	
    	// if CE button clicked clears the inputDisplay back to 0
    		if(buttonText.equals("CE")) {
    			newNumber = false;
    			inputDisplay.clear();
    			inputDisplay.setText("0");
    			decimal = false;
    			return;
    		}
    		
    		// clear everything when button is pressed
    		if (buttonText.equals("C")) {
    			inputDisplay.clear();
    			inputDisplay.setText("0");
    			memory = "";
    			num1 = 0;
    			newNumber = false;
    			operator = "";
    		}
    		
    		// if button clicked matches a number value display it in the inputDisplay
    		if(buttonText.matches("[0-9\\,]")) {
    			
    			if(!newNumber) {
    				newNumber = true;
    				inputDisplay.clear();
    			}

    			inputDisplay.appendText(buttonText);
    			return;
    		}

    		// if a button equals a decimal point check if there is one if not display it
    		if(buttonText.equals(".")) {
    			if(decimal == true) {
    				return;
    			}
    			else {
    			inputDisplay.appendText(buttonText);
    			decimal = true;
    			}
    			
    		}
    		
    		// if +/- button is clicked multiply by -1 to change the value
    		if(buttonText.equals("+ -")) {
    			if(decimal == true) {
    			double plusMinus = Double.parseDouble(inputDisplay.getText());
    			plusMinus = plusMinus * (-1);
    			inputDisplay.setText(String.valueOf(plusMinus));
    			}
    			if(decimal == false) {
        			int plusMinus = Integer.parseInt(inputDisplay.getText());
        			plusMinus = plusMinus * (-1);
        			inputDisplay.setText(String.valueOf(plusMinus));
    			}
    		}


    	}
    
    // event to handle the operator buttons
    @FXML
    private void operator(ActionEvent evt) {
    	Button button = (Button) evt.getSource();
    	String buttonText = button.getText();

    	
    	if (!buttonText.equals("=")) {
    		if(!operator.isEmpty())
    			return;

    		operator = buttonText;
    		num1 = Double.parseDouble(inputDisplay.getText());
    		inputDisplay.clear();
    		inputDisplay.setText("0");
    		newNumber = false;
    	
    		
    	}
    	
    	else if (buttonText.equals("=")){
    		if (operator.isEmpty())
    			return;

    			inputDisplay.setText(String.valueOf(calculate(num1, Double.parseDouble(inputDisplay.getText()), operator)));
    			operator = "";
    			newNumber = false;
    		
    	}

    }
    
    //event for the memory add, recall and clear
    @FXML
    public void memory(ActionEvent evt) {
    	Button button = (Button) evt.getSource();
    	String buttonText = button.getText();
    	
    	if (buttonText.equals("M+")) {
    		memory = inputDisplay.getText();
    		newNumber = true;
    		inputDisplay.clear();
    		inputDisplay.setText("0");
    	}
    	if (buttonText.equals("MR")) {
    		inputDisplay.clear();
    		inputDisplay.appendText(memory);
    	}
    	if (buttonText.equals("MC")) {
    		memory = "";
    		inputDisplay.clear();
    		inputDisplay.setText("0");
    	}
    }

    			

    //keyevent to handle if keypad is being used
    @FXML
    public void keypad(KeyEvent e) {
		if(!newNumber) {
			newNumber = true;
			inputDisplay.clear();
		}

		else inputDisplay.appendText(e.getCharacter());
	}
    
    public double calculate(double num1, double num2, String operator) {
    	switch (operator) {
    	case "+":
    		return num1 + num2;

    	case "-":
    		return num1 - num2;

    	case "*":
    		return num1 * num2;

    	case "/":
    		if(num2 == 0)
    			return 0;
    		return num1 / num2;
    	
    	}
    	return 0;
    }
			
    	
    	

		

    
    

    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
    	
    }



}
