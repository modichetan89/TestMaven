package landmark.LifestyleAutomation;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




import resources.BaseClass;

public class Listeners implements ITestListener {
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	BaseClass b1 = new BaseClass();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getName()+" test case started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("The name of the testcase passed is :"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			b1.getScreenshot(result.getName());
			//remove below line if facing error
			log.info("The name of the testcase failed is :"+result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("The name of the testcase Skipped is :"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
