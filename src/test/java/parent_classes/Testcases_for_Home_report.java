package parent_classes;

public class Testcases_for_Home_report extends Home
{

    public void testcase_creation()
    {
        extent.attachReporter(htmlReporter);


        logger1 = extent.createTest("Login Test");
        logger2 = extent.createTest("Screenshot for failed testcase");
    }
}
