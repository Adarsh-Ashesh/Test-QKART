package QKART_SANITY_LOGIN.Module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
    RemoteWebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/checkout";

    public Checkout(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCheckout() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }

    /*
     * Return Boolean denoting the status of adding a new address
     */
    public Boolean addNewAddress(String addresString) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Click on the "Add new address" button, enter the addressString in the address text
             * box and click on the "ADD" button to save the address
             */
            WebElement addNewAddressElement = driver.findElement(By.id("add-new-btn"));
            addNewAddressElement.click();

            WebElement addressInputElement = driver.findElement(
                    By.xpath(" //textarea[@placeholder = 'Enter your complete address']"));
            addressInputElement.sendKeys(addresString);

            // button[text()='Add']
            WebElement addButtonElement = driver.findElement(By.xpath(" //button[text()='Add']"));
            addButtonElement.click();
            Thread.sleep(5000);

            WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + addresString + "']")));


            return false;


        } catch (Exception e) {
            System.out.println("Exception occurred while entering address: " + e.getMessage());
            return false;

        }
    }

    /*
     * Return Boolean denoting the status of selecting an available address
     */
    public Boolean selectAddress(String addressToSelect) {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            /*
             * Iterate through all the address boxes to find the address box with matching text,
             * addressToSelect and click on it
             */
            WebElement addresElement = driver.findElement(By.xpath("//input[@type='radio']"));


            // List<WebElement> addresElements =
            // driver.findElements(By.xpath("//input[@type='radio']"));
            Thread.sleep(3000);

            // for (WebElement addresElement : addresElements) {
            // String actualAddress = addresElement.getText();

            // if (actualAddress.equals(addressToSelect)) {
            addresElement.click();
            return true;
            // }
            // }

            // System.out.println("Unable to find the given address");
            // return false;
        } catch (Exception e) {
            System.out.println(
                    "Exception Occurred while selecting the given address: " + e.getMessage());
            return false;
        }

    }

    /*
     * Return Boolean denoting the status of place order action
     */
    public Boolean placeOrder() {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 05: MILESTONE 4
            // Find the "PLACE ORDER" button and click on it
        //    WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        //    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='PLACE ORDER']")));
         

            WebElement placeOrderElement =
                    driver.findElement(By.xpath("//button[text()='PLACE ORDER']"));
            placeOrderElement.click();

            return false;

        } catch (Exception e) {
            System.out.println("Exception while clicking on PLACE ORDER: " + e.getMessage());
            return false;
        }
    }

    /*
     * Return Boolean denoting if the insufficient balance message is displayed
     */
    public Boolean verifyInsufficientBalanceMessage() {
        try {
            // TODO: CRIO_TASK_MODULE_TEST_AUTOMATION - TEST CASE 07: MILESTONE 6
            WebElement dispalyEleemnt =
                    driver.findElement(By.xpath("//div[@id='notistack-snackbar']"));
            String displayText = dispalyEleemnt.getText();
            System.out.println("Actual Meesage Displayed: Test CCase 07 " + displayText);
            String validateMessage =
                    "You do not have enough balance in your wallet for this purchase";
            if (displayText.contains(validateMessage)) {
                return true;
            }



            return false;

        } catch (Exception e) {
            System.out.println(
                    "Exception while verifying insufficient balance message: " + e.getMessage());
            return false;
        }
    }

    public boolean verifyQKartProductIsDisplaying(int frame){
          boolean condition = false;
          WebElement firstIframe = driver.findElement(By.xpath("(//iframe)[" + frame + "]"));
          driver.switchTo().frame(firstIframe);

          WebElement viewCartElement = driver.findElement(By.xpath("//button[text()='View Cart']"));
          WebElement buyNowElement = driver.findElement(By.xpath("//button[text()='Buy Now']"));

          if(viewCartElement.isEnabled() && buyNowElement.isEnabled()){
            condition = true;
          }
          driver.switchTo().defaultContent();
          return condition;
    }


    public boolean verifyCoronaStatsAdvertisment(){
        boolean condition = false;
        WebElement adIframe = driver.findElement(By.xpath("(//iframe)[3]"));
        driver.switchTo().frame(adIframe);
    
        WebElement covidElement = driver.findElement(By.xpath("//div[text()='COVID-19']"));
        condition = covidElement.isDisplayed();

        driver.switchTo().defaultContent();
        
        WebElement cnusElement = driver.findElement(By.xpath("//p[text()='Contact us']"));
        cnusElement.click();
        return condition;
        
    }

    public boolean verifyNameElement(){
        boolean condition = false;
   
        WebElement nameElement = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        condition = nameElement.isDisplayed();
       
        return condition;
       
    }

    public boolean verifyEmailElement(){
        boolean condition = false;
   
        WebElement emailElement = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        condition = emailElement.isDisplayed();
       
        return condition;
       
    }

    public boolean verifyMeassageElement(){
        boolean condition = false;
   
        WebElement messageElement = driver.findElement(By.xpath("//input[@placeholder='Message']"));
        condition = messageElement.isDisplayed();
       
        return condition;
       
    }

}
