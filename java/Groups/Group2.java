package Groups;

import org.testng.annotations.Test;

@Test(groups= {"all"})
public class Group2 {
	
	
	
	@Test(groups= {"smoke"})
	public void Test4()
	{
		System.out.println("Test4");
	}
	

	@Test(groups= {"smoke","functional","sanity","ios.smoke"})
	public void Test5()
	{
		System.out.println("Test5");
	}


	@Test(groups= {"functional","regression", "Window.smoke"})
	public void Test6()
	{
		System.out.println("Test6");
	}
	
	
	@Test
	public void Test7()
	{
		System.out.println("Test7");
	}


}
