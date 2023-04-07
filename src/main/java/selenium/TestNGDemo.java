package selenium;

import org.testng.annotations.Test;

public class TestNGDemo {
 
	@Test(priority = 1)
	void Test1() {
		TC1_LoginErrorMsg tc1 = new TC1_LoginErrorMsg ();
		tc1.runTest();
	}
	@Test(priority = 2)
	void Test2() {
		 TC3_CheckRemembberMe tc2 = new TC3_CheckRemembberMe ();
		
		tc2.runTest();
	}
}
