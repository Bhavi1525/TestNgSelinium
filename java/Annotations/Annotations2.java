package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations2 {
	
	
	
	@BeforeClass
	public void login()
	{
		System.out.println("login");
	}
	
	@AfterClass
	public void logout()
	{
		System.out.println("logout");
	}
	
	@Test
	public void serach()
	{
		System.out.println("search");
	}
	
	@Test
	public void advserach()
	{
		System.out.println("advserach");
	}

}
