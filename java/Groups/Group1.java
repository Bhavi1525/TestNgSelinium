package Groups;

import org.testng.annotations.Test;

public class Group1 {
	
	
	@Test(groups= {"smoke","Window.smoke"})
	public void Test1()
	{
		System.out.println("Test1");
	}
	

	@Test(groups= {"smoke","regression","sanity"})
	public void Test2()
	{
		System.out.println("Test2");
	}


	@Test(groups= {"functional","sanity","Window.smoke"})
	public void Test3()
	{
		System.out.println("Test3");
	}

}
