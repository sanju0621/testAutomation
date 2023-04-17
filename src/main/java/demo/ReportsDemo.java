package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsDemo {

	public static void main(String[] args) {
		String sFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+sFileNamePrefix+"_SFDC.html";
		ExtentReports extent = new ExtentReports();
		ExtentHtmlReporter report = new ExtentHtmlReporter(filePath);
		extent.attachReporter(report);
	}

}
