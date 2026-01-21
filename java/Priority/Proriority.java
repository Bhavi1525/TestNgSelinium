package Priority;

import org.testng.annotations.Test;

public class Proriority {

	@Test(priority=1)
	public void signup()
	{
		System.out.println("signup");
	}
	
	@Test(priority=2)
	public void login()
	{
		System.out.println("login");
	}
	
	@Test(priority=3)
	public void serachtheflight()
	{
		System.out.println("serachtheflight");
	}
	@Test(priority=4)
	public void booktheticket()
	{
		System.out.println("booktheticket");
	}
	
	@Test(priority=5)
	public void savetheticket()
	{
		System.out.println("savetheticket");
	}
	@Test(priority=6)
	public void logout()
	{
		System.out.println("logout");
	}
	

}
