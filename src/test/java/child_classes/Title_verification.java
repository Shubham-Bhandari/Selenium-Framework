package child_classes;

import com.aventstack.extentreports.Status;
import parent_classes.Home;

public class Title_verification extends Home
{

    public static void website_title_verification(String expected_title) throws InterruptedException
    {

        String titlename= wd.getTitle();
        Thread.sleep(3000);
        System.out.println("title name is = "+ titlename);
        logger1.log(Status.PASS, "Title name is- "+ titlename);
        Thread.sleep(3000);
        String expectedtitle=expected_title;
        Thread.sleep(3000);

        if(titlename.equals(expectedtitle))
        {

            logger1.log(Status.PASS, "Title is verified of "+expected_title);
            //System.out.println("Website title verification Testcase is passed");

        }
        else
        {
            logger1.log(Status.FAIL, "Title is not verified for "+expected_title);
            //	System.out.println("Website title verification is failed");
        }
    }
}
