package listeners;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Itestlistener.class)
public class TestClass1 {
	
	
	@Test
	public void TestMethod1()
	{
		System.out.println("i am testmethod1");
	}
	
	@Test
	public void TestMethod2()
	{
		System.out.println("i am testmethod2");
		assertTrue(false);
	}
	
	@Test(timeOut = 1000)
	public void TestMethod3() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("i am testmethod3");
	}
	
	@Test(dependsOnMethods ="TestMethod3" )
	public void TestMethod4()
	{
		System.out.println("i am testmethod4");
	}
	

}
