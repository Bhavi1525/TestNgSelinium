package Annotations;

import org.testng.annotations.Test;

public class C3 {
	
	@Test
	public void PQR()
	{
		System.out.println("this is PQR");
	}
	
	@org.testng.annotations.BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	@org.testng.annotations.AfterSuite
	public void AfterSuite()
	{
		System.out.println("Aftersuite");
	}

}
