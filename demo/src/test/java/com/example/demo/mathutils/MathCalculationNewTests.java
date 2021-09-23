package com.example.demo.mathutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MathCalculationNewTests {

	@Test
	public void calculationTest() {
		
		MathCalculation mathCalculation = new MathCalculation();
		int actualResult = mathCalculation.calculation(5, 2);
		
		assertEquals(7, actualResult);
		
	}
}
