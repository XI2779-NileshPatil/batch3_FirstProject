package com.example.demo.mathutils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class MathCalculationTests {

	@Test
	public void calculationTest() {
		
		MathCalculation mathCalculation = new MathCalculation();
		//mathCalculation.calculation(0, 0);
		
		//0,0 = 0
		//-1, 1 = 0
		//2,2 =4
		//-2,2 =0
		//3,4 =7
		
		assertEquals(0, mathCalculation.calculation(0, 0));
		assertEquals(0, mathCalculation.calculation(-1, 1));
		assertEquals(4, mathCalculation.calculation(2, 2));
		assertEquals(0, mathCalculation.calculation(-2, 2));
		assertEquals(7, mathCalculation.calculation(3, 4));
		

		
	}
}
