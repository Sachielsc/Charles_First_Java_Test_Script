package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentHtmlReporter htmlReporter;
    private static String filePath = System.getProperty("user.dir") + "/Extent/extentreport.html";

    public static ExtentReports GetExtent() {
        if (extent != null) {
            return extent;
        }//avoid creating new instance of html file
        extent = new ExtentReports();
        extent.attachReporter(getHtmlReporter());
        extent.setSystemInfo("Author","Charles");
        extent.setSystemInfo("OS","Windows");
        extent.setSystemInfo("Browser","Google Chrome");
        extent.setSystemInfo("Date/Time", new Date().toString());
        return extent;
    }

    private static ExtentHtmlReporter getHtmlReporter() {
        htmlReporter = new ExtentHtmlReporter(filePath);

        // make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Set document title here");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setReportName("Set report name here");

        return htmlReporter;
    }

    public static ExtentTest createTest(String name, String description) {
        test = extent.createTest(name, description);
        return test;
    }

}