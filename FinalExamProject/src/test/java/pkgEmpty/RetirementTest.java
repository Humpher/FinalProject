package pkgEmpty;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void PVTest() {
		
		DecimalFormat form = new DecimalFormat("##.00");
		
		Retirement totalTest = new Retirement();
		
			totalTest.setiYearsRetired(20);
			totalTest.setdAnnualReturnRetired(0.02);
			totalTest.setdRequiredIncome(10000);
			totalTest.setdMonthlySSI(2642);
			
			double answer = totalTest.TotalAmountSaved();
			
			//System.out.println(form.format(answer));
			
			assertEquals(answer, 1454485.55, 0.01);
	}
	
	
	@Test
	public void PMTTest() {
		
		DecimalFormat form1 = new DecimalFormat("##.00");
		
		Retirement toSaveTest = new Retirement();
		
		toSaveTest.setdAnnualReturnWorking(0.07);
		toSaveTest.setiYearsToWork(40);
		toSaveTest.setiYearsRetired(20);
		toSaveTest.setdAnnualReturnRetired(0.02);
		toSaveTest.setdRequiredIncome(10000);
		toSaveTest.setdMonthlySSI(2642);
		
		double amount = Math.abs(toSaveTest.AmountToSave());
		
		//System.out.println(form1.format(amount));
		
		assertEquals(amount, 554.13, 0.01);
	}
}
