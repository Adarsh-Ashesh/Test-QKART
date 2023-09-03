package QKART_SANITY_LOGIN.Module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Footer{ 

RemoteWebDriver driver;
public Footer(RemoteWebDriver driver) {
    this.driver = driver;
}

public void clickOnPrivacyPolicy() throws InterruptedException{

    WebElement privacyElement = driver.findElement(By.xpath("//a[text()='Privacy policy']"));
    privacyElement.click();
    Thread.sleep(1000);
    
}

public boolean verifyPrivacyPolicyPage(){
    WebElement privacyElement = driver.findElement(By.xpath("//h2[text()='Privacy Policy']"));
    return privacyElement.isDisplayed();
}

public void clickOnTermsOfService() throws InterruptedException{

    WebElement termsOfService = driver.findElement(By.xpath("//a[text()='Terms of Service']"));
    termsOfService.click();
    Thread.sleep(1000);
    
}

public boolean verifyTermsOfServicePage(){
    WebElement termsOfService = driver.findElement(By.xpath("//h2[text()='Terms of Service']"));
    return termsOfService.isDisplayed();
}

}