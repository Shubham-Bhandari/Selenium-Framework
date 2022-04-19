package parent_classes;

public class Testcases_for_Home_report extends Home
{

    public void testcase_creation()
    {
        extent.attachReporter(htmlReporter);


        logger1 = extent.createTest("Title Verification");
        logger2 = extent.createTest("Text Verification");
        logger3 = extent.createTest("Screenshot for failed testcase");
    }
}
