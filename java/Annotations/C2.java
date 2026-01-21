package Annotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class C2 {
	
	
	@Test
	public void abc()
	{
		System.out.println("this is abc");
	}
	
	@AfterMethod
	public void AFtermethod()
	{
		System.out.println("AFtermethod");
	}

}
