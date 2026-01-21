package ParallelTest;

import org.testng.annotations.Test;

public class TestClass4 {
	
	
	@Test
	public void TestMethod13()
	{
		System.out.println("TestClass4>>>>TestMethod9 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod14()
	{
		System.out.println("TestClass4>>>>TestMethod10 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod15()
	{
		System.out.println("TestClass4>>>>TestMethod11 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod16()
	{
		System.out.println("TestClass4>>>>TestMethod12 "+Thread.currentThread().getId());
	}

}
