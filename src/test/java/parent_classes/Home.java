package parent_classes;

import child_classes.Title_verification;
import child_classes.demo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import config.Base;
import library.Utility;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class Home extends Base {

    public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Report/home.html");
    public static ExtentReports extent = new ExtentReports();

    public static ExtentTest logger1,logger2;


    @BeforeSuite
    void initialization_browser_opening() throws InterruptedException, IOException
    {
        System.out.println(getobject("url"));
        initialzation(getobject("url"));
        Testcases_for_Home_report testcase=new Testcases_for_Home_report();
        testcase.testcase_creation();
    }


    @Test(priority=1)
    void title_verification() throws InterruptedException
    {

        Title_verification.website_title_verification("Neil's Whiteboard");
    }

   @Test
   void verification()
   {
       demo d= PageFactory.initElements(wd,demo.class);
       d.view();
   }




    @AfterMethod
    void fail_testcase(ITestResult result)
    {
        try {

            if(ITestResult.FAILURE==result.getStatus())
            {
                String temp= Utility.attachscreenshotreport(wd, result.getName());


                logger2.fail("Testcase name"+ result.getName());
                logger2.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

            }}
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


    }

    @AfterSuite
    void teardown_browerclosing()
    {
        teardown();
        extent.flush();
    }
}
