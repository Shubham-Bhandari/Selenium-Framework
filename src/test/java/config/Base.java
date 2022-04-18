package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

public class Base {

    static Properties prop;

    public static WebDriver wd;
    public static File folder;
    //to load data from property file
    public static void load_property_file() throws IOException
    {
        prop=new Properties();

        try
        {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\config\\config.properties");
            prop.load(input);

        }



         catch (FileNotFoundException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //to get data from config property file
    public static String getobject(String Data) throws IOException
    {
        load_property_file();
        String data= prop.getProperty(Data);
        return data;
    }


    //For browser opening
    public void initialzation(String URL) throws InterruptedException

    {

        System.setProperty("webdriver.chrome.driver", "D:\\Shubham\\SeleniumFramework\\Driver\\chromedriver.exe");

        //for chrome
        ChromeOptions option=new ChromeOptions();

        Map<String, Object> prefs=new HashMap<String, Object>();

        prefs.put("profile.default_content_settings.popups", 0);
//        prefs.put("download.default_directory", folder.getAbsolutePath());
        option.setExperimentalOption("prefs", prefs);
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, option);


        wd=new ChromeDriver(cap);
        wd.get(URL);
        Thread.sleep(8000);
        wd.manage().window().maximize();
    }


    //To close browser
    public void teardown()
    {

        wd.close();


    }

}
