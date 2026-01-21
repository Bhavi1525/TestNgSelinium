package Annotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Annotations4 {

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest - runs once before all classes");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass - runs before each class");
	}
}
