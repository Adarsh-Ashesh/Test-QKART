//import org.testng.ITestContext;
package QKART_TESTNG;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTestNG implements ITestListener {
    // public void onStart(ITestContext context) {
    //     System.out.println("onStart method started");
    // }

    public void onTestFailure(ITestResult result) {
        System.out.println("Code to take screenshot!! : " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Method" +result.getName());
    }
}
