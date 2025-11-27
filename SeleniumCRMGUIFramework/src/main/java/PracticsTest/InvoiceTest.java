package PracticsTest;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
public class InvoiceTest extends BaseClass{
	@Test
	public void createInvoice() {
		Reporter.log("execute create invoice ");
		@Nullable
		String var = driver.getTitle();
		Reporter.log(var);
		Assert.assertEquals(var, "Login");
		Reporter.log("Step-1");
		Reporter.log("Step-2");
		Reporter.log("Step-3");
		Reporter.log("Step-4");
	}
	@Test
	public void createInvoiceWithContact() {
		Reporter.log("execute create invoice with contact");
		Reporter.log("Step-1");
		Reporter.log("Step-2");
		Reporter.log("Step-3");
		Reporter.log("Step-4");
	}
	
}