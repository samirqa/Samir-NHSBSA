/*
@author Kunal Soni
*/

package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.core.plugin.JsonFormatter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestBase {

    private static final String JSON_ARCHIVE = "target/json/jsonArchive.json";
  //  public static WebDriver driver;
    public static Properties properties;
    public static Date date = new Date();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    public static String dt = formatter.format(date);
    public static String reportDestination = "reports/report_" + dt + ".html";
    public static FileReader fileReader;
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static ExtentReports extent;
    public static JsonFormatter json;

//    @AfterSuite
//    public void tearDown() {
//
//        driver.quit();
//        extent.flush();
//    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getName() + " test case is failed. " + "<span class='badge badge-danger'> Fail </span>" + result.getThrowable());
            test.fail(new Throwable());
            test.fail(new Exception());

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getName() + " test case is skipped." + "<span class='badge badge-warning'> Skip </span>");

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(result.getName() + " test case is Passed." + "<span class='badge badge-success'> Success </span>");
        }
    }

//    public static void openUrl(String url) {
//        if (driver != null)
//            driver.get(url);
//    }

    public void extentReportSpark() {

        spark = new ExtentSparkReporter(reportDestination);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser Name", properties.getProperty("BrowserName"));
        extent.setSystemInfo("Environment", properties.getProperty("Environment"));
        extent.setSystemInfo("Base URL", properties.getProperty("URL"));
        extent.setSystemInfo("User Name", properties.getProperty("UserName"));
        extent.setSystemInfo("User Email", properties.getProperty("UserEmail"));

        spark.config().setDocumentTitle("Sample Automation Testing Report");
        spark.config().setReportName("Sample Automation Test Suite");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    public void propertiesLoad() throws IOException {

        try {
            fileReader = new FileReader("config/QA.properties");
            properties = new Properties();
            properties.load(fileReader);

        } catch (FileNotFoundException ex) {
            test.info("*************************************************");
            test.info("Property file you are looking for does not exist.");
            test.info("*************************************************");
        }
    }
}