package Screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestlistener extends BasicTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestContext().getName()+""+ result.getMethod().getMethodName());
		screenshot(result.getTestContext().getName()+""+ result.getMethod().getMethodName()+".jpg");
	}
	
	

}
