package child_classes;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import parent_classes.Home;

public class demo extends Home
{
    @FindBy(xpath = "//b[text()='bold piece of text']")
    WebElement bold;

    @FindBy(xpath = "//u[text()='underlined piece of text']")
    WebElement underline;


    public void view()
    {
        String text= bold.getText();
        System.out.println("First text is:"  +text);
        logger2.log(Status.PASS, "Bold text is verified");

        String text2= underline.getText();
        System.out.println("Second text is:"  +text2);
    logger2.log(Status.PASS, "Underline text is verified");


    }
}
