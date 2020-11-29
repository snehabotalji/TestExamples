package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils mathUtils;
	
	@BeforeAll
	void beforeAllInit()
	{
		System.out.println("before all ... ");
	}
	
	@BeforeEach
	void init()
	{
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup()
	{
		System.out.println("cleaning up .... ");
	}
	
	@Test
	@Disabled
	void test() {
		int expected = 3;
		int actual = mathUtils.add(1,2);
		assertEquals(expected, actual,"add two numbers");
	}

	@Test
	@DisplayName("This is to test divide method")
	@EnabledOnOs(OS.LINUX)
	void testDivide()
	{
		assertThrows(ArithmeticException.class,() -> mathUtils.divide(1, 0),"Divide the numbers");
	}
	@Test
	@DisplayName("This method is to test AreaOFCircle")
	void testComputeAreaOfCircle()
	{
		boolean value=false;
		assumeTrue(value);
		assertEquals(314.1592653589793,mathUtils.computeAreaOfCircle(10),"Should return right area of circle");
	}
}
