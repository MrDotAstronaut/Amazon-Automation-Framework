package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extents {

    private ExtentSparkReporter reporter = new ExtentSparkReporter(".\\reports\\index.html");
    private ExtentReports report = new ExtentReports();

    public ExtentReports initExtent(){

        reporter.config().setReportName("Amazon-Automation-Framework");
        reporter.config().setDocumentTitle("Results");
        report.attachReporter(reporter);
        report.setSystemInfo("SDET", "John Thomas");
        return report;

    }
}
