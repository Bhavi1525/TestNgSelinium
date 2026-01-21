package Annotations;

import org.testng.annotations.Test;

public class NewTest {
	
	@Test
	public void TestMethod1()
	{
		System.out.println("TestMethod1");
	}
	
	@Test
	public void TestMethod2()
	{
		System.out.println("TestMethod2");
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("BeforeMethod");
	}
	
	@org.testng.annotations.AfterMethod
	public void AfterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass()
	{
		System.out.println("BeforeClass");
	}
	@org.testng.annotations.AfterClass
	public void AfterClass()
	{
		System.out.println("BeforeClass");
	}
	
	@org.testng.annotations.BeforeTest
	public void BeforeTest()
	{
		System.out.println("BeforeTest");
	}
	@org.testng.annotations.AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest");
	}
	
	@org.testng.annotations.BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	
	@org.testng.annotations.AfterSuite
	public void AfterSuite()
	{
		System.out.println("AfterSuite");
	}
	
	
	
	
	

}
