package com.xcart.mobile.utility;

import com.xcart.mobile.drivermanager.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;

public class Utility extends DriverManager {


    /**
     * This method will click on element
     *
     * @ param by
     */
    public void doClickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This method will find the element and clear all the data from it
     *
     * @param by
     */
    public void doFindElementAndClearText(By by) {
        WebElement loginlink = driver.findElement(by);
        loginlink.clear();
    }


    /**
     * This method will get text from element
     *
     * @param by
     * @return
     */
    public String doGetTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    public String doGetAttributeFromElement(By by, String attribute){
        return driver.findElement(by).getAttribute(attribute);

    }


    /**
     * This method will send text to an element
     *
     * @param by
     * @param text
     */
    public void doSendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);//
    }

    /**
     * This method will switch to an Alert from main window and click on the 'OK' button of the alert
     */
    public void doSwitchToAlert() {
        driver.switchTo().alert();

    }

    /**
     * This method will switch to an alert from main window and click on the 'Cancel' button of the alert
     */
    public void doAcceptAlert() {
        driver.switchTo().alert().accept();

    }

    /**
     * This method will switch to an alert from main window and capture text from it
     *
     * @return
     */
    public String doGetTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * This method will send some data to the alert box
     *
     * @param textToSend
     */
    public void doSendTextToAlert(String textToSend) {
        driver.switchTo().alert().sendKeys(textToSend);
    }

    /**
     * This method will select the option that displays the text matching the parameter
     *
     * @param by
     * @param text
     */
    public void doSelectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method selects the option whose value matches the specified parameter
     *
     * @param by
     * @param value
     */
    public void doSelectByValue(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method selects the option at the given index position
     *
     * @param by
     * @param index
     */
    public void doSelectByIndex(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);

    }

    /**
     * This method will get all elements from the dropdown list and print in console
     *
     * @param by
     */
    public void doSelectGetOptionsAndPrint(By by) {
        Select optionsSelect = new Select(driver.findElement(by));
        List<WebElement> optionNames = optionsSelect.getOptions();
        for (int i = 0; i < optionNames.size(); i++) {
            System.out.println(optionNames.get(i).getText());
        }
    }

    /**
     * This method performs click and hold at the source location, moves to target location
     * and then releases the mouse
     *
     * @param source
     * @param target
     */
    public void doDragAndDrop(By source, By target) {
        Actions builder = new Actions(driver);
        WebElement draggable = driver.findElement(source);
        WebElement droppable = draggable.findElement(target);
        builder.dragAndDrop(draggable, droppable).build().perform();
    }

    /**
     * This method will hover the mouse over a particular element and click it
     *
     * @param by
     */
    public void doMouseHoverAndClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).click().build().perform();
    }

    public void doMouseHoverNoClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).build().perform();

    }

    public void doMouseHoverOnFirstThenSecondAndClick(By by1, By by2) {
        Actions hover = new Actions(driver);
        WebElement destination1 = driver.findElement(by1);
        WebElement destination2 = driver.findElement(by2);
        hover.moveToElement(destination1).moveToElement(destination2).click().build().perform();

    }


    /**
     * This method performs a Right Click Mouse Action at the current mouse location
     *
     * @param by
     */
    public void doRightClick(By by) {
        Actions rightClick = new Actions(driver);
        WebElement a = driver.findElement(by);
        rightClick.contextClick().build().perform();
    }

    /**
     * Moves the slider from its current position to the desired position
     *
     * @param sliderBar
     * @param sliderBox
     * @param xAxis
     * @param yAxis
     */
    public void doSliderMovement(By sliderBar, By sliderBox, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(driver);
        WebElement mainSlider = driver.findElement(sliderBar);
        WebElement slider = driver.findElement(sliderBox);
        moveSlider.dragAndDropBy(slider, xAxis, yAxis).build().perform();

    }

    public String doRandomEmailGenerator() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random randomEmail = new Random();
        while (email.length() < 10) {
            int index = (int) (randomEmail.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        String saltStr = (email.toString() + "@gmail.com");
        return saltStr;
    }

    public void doVerifyElements(String expectedMessage, String actualMessage, String displayMessage) {
        Assert.assertEquals(expectedMessage, actualMessage, displayMessage);
    }

    public void doVerifyElements(String expectedMessage, By by, String displayMessage) {
        Assert.assertEquals(expectedMessage, by, displayMessage);
    }

    public void doSortDataFromElements(By by) {
        List<WebElement> name = driver.findElements(by);//Storing webelements in a list of webelement
        String[] beforesort = new String[name.size()];//array declaration with size equal to list size
        for (int i = 0; i < name.size(); i++) {
            beforesort[i] = name.get(i).getText().trim();//will capture all the index positions, get text and trim spaces
        }
        Arrays.sort(beforesort);//sorting the array
        WebElement sort = driver.findElement(by);
        sort.click();
        name = driver.findElements(by);

        String[] aftersort = new String[name.size()];
        for (int i = 0; i < name.size(); i++) {
            aftersort[i] = name.get(i).getText().trim();
            Assert.assertEquals(beforesort, aftersort, "productname is not sorted");

        }

    }

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return signIn;
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    public void selectMenu(By by, String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }
    public void verifyTheSortingOrderOfPriceLowToHighIsCorrect(By beforeFilterElements, By dropDown, By lowToHigh ){
        List <WebElement> beforeFilterWebElementPrice = driver.findElements(beforeFilterElements);
        List<Double> beforeFilterDoublePriceList = new ArrayList<>();
        for (WebElement p : beforeFilterWebElementPrice) {
            beforeFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }
        //Select dropDownBox = new Select(driver.findElement(dropDown));
        //dropDownBox.selectByVisibleText("Price Low - High");
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(lowToHigh);

        List<WebElement> afterFilterWebElementPriceList = driver.findElements(beforeFilterElements);
        List<Double> afterFilterDoublePriceList = new ArrayList<>();

        for(WebElement p : afterFilterWebElementPriceList) {
            afterFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }

        Collections.sort(beforeFilterDoublePriceList);
        Assert.assertEquals(beforeFilterDoublePriceList, afterFilterDoublePriceList, "List is not sorted according to price Low to High");

        }


}




