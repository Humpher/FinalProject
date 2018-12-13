package pkgApp.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import javax.validation.constraints.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	
	//Labels
	@FXML
	private Label lblSaveEachMonth; 
	
	@FXML
	private Label lblWhatUNeedSaved;
	
	//Textfields
	
	@FXML
	private TextField txtYearsToWork;
	
	
	@FXML
	private TextField txtExpectedAnnualReturn;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtActualAnnualReturn;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;


	private Stage dialogStage;
	
	
	
////*************************************************
	
//	int textYearsToWork = Integer.parseInt(txtYearsToWork.getText());
//	
//	
//	double textAnnualReturnWorking = Double.parseDouble(txtExpectedAnnualReturn.getText());
//	
//	
//	int textYearsRetired = Integer.parseInt(txtYearsRetired.getText());
//	
//	
//	double textAnnualReturnRetired = Double.parseDouble(txtActualAnnualReturn.getText());
//	
//
//	double textRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
//
//	double textMonthlySSI = Double.parseDouble(txtMonthlySSI.getText());
//	
//	
//		
	
//**********
	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }
	
	
	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		lblSaveEachMonth.setText("");
		lblWhatUNeedSaved.setText("");
		txtYearsToWork.setText("");
		txtExpectedAnnualReturn.setText("");
		txtYearsRetired.setText("");
		txtActualAnnualReturn.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		
		
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		if(! txtYearsToWork.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") ||
				! txtExpectedAnnualReturn.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") ||
				! txtYearsRetired.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") ||
				! txtActualAnnualReturn.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") ||
				! txtRequiredIncome.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") || 
				! txtMonthlySSI.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") ) {
			
			 Alert alert = new Alert(AlertType.ERROR);
	            alert.initOwner(dialogStage);
	            alert.setTitle("Invalid Fields");
	            alert.setHeaderText("Please correct invalid fields");
	            //alert.setContentText(errorMessage);
	            
	            alert.showAndWait();
			
		}
		
		
		
			
		
		DecimalFormat form = new DecimalFormat("##.00");
		
		int textYearsToWork = Integer.parseInt(txtYearsToWork.getText());
		double textAnnualReturnWorking = Double.parseDouble(txtExpectedAnnualReturn.getText());	
		int textYearsRetired = Integer.parseInt(txtYearsRetired.getText());
		double textAnnualReturnRetired = Double.parseDouble(txtActualAnnualReturn.getText());
		double textRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
		double textMonthlySSI = Double.parseDouble(txtMonthlySSI.getText());
		
		
		Retirement rt = new Retirement();
		
		rt.setiYearsToWork(textYearsToWork);
		rt.setdAnnualReturnWorking(textAnnualReturnWorking);
		rt.setiYearsRetired(textYearsRetired);
		rt.setdAnnualReturnRetired(textAnnualReturnRetired);
		rt.setdRequiredIncome(textRequiredIncome);
		rt.setdMonthlySSI(textMonthlySSI);
		
		
		lblSaveEachMonth.setText("$"+ form.format((Math.abs(rt.AmountToSave()))));
		lblWhatUNeedSaved.setText("$"+ form.format((Math.abs(rt.TotalAmountSaved()))));
		
		


	}
		 

}

	

