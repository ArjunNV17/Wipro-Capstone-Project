package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            // Format date and time separately
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String time = new SimpleDateFormat("HH-mm-ss").format(new Date());

            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + date + "_" + time + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Execution Report");
            spark.config().setReportName("NopCommerce Test Report - " + date + " " + time);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Add system/environment info
            extent.setSystemInfo("Project", "NopCommerce");
            extent.setSystemInfo("Tester", "QA Team");
            extent.setSystemInfo("Execution Date", date);
            extent.setSystemInfo("Execution Time", time);
        }
        return extent;
    }

	
}