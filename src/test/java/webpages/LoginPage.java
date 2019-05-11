package webpages;

import main.CucumberRunner;
import org.openqa.selenium.By;


public class LoginPage extends CucumberRunner {

    public static final By username = By.xpath("//input[@id='email']");
    public static final By password = By.xpath("//input[@id='pass']");
    public static final By Login_button = By.xpath("//input[@id='u_0_2']");



}
