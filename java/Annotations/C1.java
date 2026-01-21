package Annotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	@BeforeClass
	public void xyz()
	{
		System.out.println("this is xyz");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("beforetest");
	}

}
