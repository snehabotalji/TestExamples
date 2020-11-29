package com.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("While running MathUtilsClass")
class MathUtilsTest {

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeEach
	void init(	TestInfo testInfo,TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		System.out.println(testInfo.getDisplayName() + "tagged with "+ testInfo.getTags());
		System.out.println();
		testReporter.publishEntry("Running" + testInfo.getDisplayName());
		mathUtils = new MathUtils();
	}

	@Nested
	@DisplayName("while running TestAddition class")
	@Tag("Math")
	class TestAddition {
		@Test
		@DisplayName("The method to check addition of positive numbers")
		void testPositive() {
			assertEquals(3, mathUtils.add(1, 2), "should return right value");
		}
		@Test
		@DisplayName("The method to check addition of negative numbers")
		void testNegative() {
			assertEquals(-3, mathUtils.add(-1, -2), "should return right value");
		}
	}

	@Test
	@DisplayName("This is to test divide method")
	@Tag("Math")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),() ->  "Divide the numbers");
	}

	@Test
	@DisplayName("This method is to test AreaOFCircle")
	void testComputeAreaOfCircle() {
		assertEquals(314.1592653589793, mathUtils.computeAreaOfCircle(10), "Should return right area of circle");
	}

	@Test
	@Tag("Math")
	@DisplayName("This method is to test multiply")
	void testMultiply() {
		assertAll(() -> assertEquals(4, mathUtils.multiply(2, 2)), () -> assertEquals(3, mathUtils.multiply(3, 1)));
	}
	
}
