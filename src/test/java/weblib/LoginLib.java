package weblib;

import main.CucumberRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class LoginLib extends CucumberRunner {

    public static void clickOnElement(By locator) {
        driver.findElement(locator).click();

    }

    public static void sendKeys(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public static void verifyDisplayText(By locator, String message) {
        String actualResult = driver.findElement(locator).getText();
        try {
            assertEquals(message, actualResult);
            System.out.println(actualResult);
        } catch (Exception e) {
            System.out.println("Cannot find the message");
        }
    }

    public static Boolean verifyIsElementDisplayed(By locator) {

        return driver.findElement(locator).isDisplayed();
    }

    /**
     * Select an element from drop list
     *
     * @param locator
     * @param option
     */
    public void selectElementByText(By locator, String option) throws Exception {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(option);
    }

    /**
     * Select an element from drop list
     *
     * @param locator
     * @param option
     */
    public static void selectElementByValue(By locator, String option) throws Exception {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(option);
    }

    /**
     * /**
     * Mouse over and Click
     *
     * @param idSelector
     * @param clickidSelector
     * @throws Exception
     */
    public static void mouseOverAndClick(By idSelector, By clickidSelector) throws Exception {
        WebElement item, itemOption;
        //get the element that shows menu with the mouseOver event
        item = driver.findElement(idSelector);
        item.click();
        Thread.sleep(8000);
        //the element that I want to click (hidden)
        itemOption = driver.findElement(clickidSelector);
        itemOption.click();
    }

    /**
     * MouseOver
     *
     * @param idSelector
     */
    public static void mouseOver(String idSelector) {
        //get the element that shows menu with the mouseOver event
        WebElement item = driver.findElement(By.cssSelector("idselector"));

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(driver);
        builder.moveToElement(item).build().perform();
    }


    public static void Hover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        WebElement menu = driver.findElement(By.id("Toolbar"));
        WebElement utmc = driver.findElement(By.id("UTMC"));
        Hover(driver, menu);
        Hover(driver, utmc);
    }

    public static void click(By locator) {
        int timeValue = 0;
        WebDriverWait wait = new WebDriverWait(driver, (long) timeValue);
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }


    /**
     * Returns the element when visible
     * Focus to
     *
     * @param locator
     * @return
     */
    public static WebElement waitForVisible(By locator) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }


    public static void selectByVisibleText(By locator, String visibleText) {

        Select s = new Select(driver.findElement(locator));
        s.selectByVisibleText(visibleText.trim());
    }


    public static void scrollToWebElement(By element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", new Object[]{driver.findElement(element)});

    }



    /**
     * Verify Text Present
     *
     * @param idSelector
     * @param textToBeFound
     * @return
     * @throws Exception
     */
    public void verifyTextPresent(String idSelector, String textToBeFound) throws Exception {
        List<WebElement> listWebElements = driver.findElements(By.cssSelector(idSelector));
        boolean found = false;

        for (WebElement webElement : listWebElements) {
            if (webElement.getText().contains(textToBeFound)) {
                found = true;
            }
        }

    }


}
