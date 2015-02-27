package com.lab2.transit.fareCalculator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lab2.transit.FareCalculator;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)


public class FareCalculatorTest {
private double expected;
private static final double DELTA = 1e-15;
		private int age;
		private String time;
		private boolean isHoliday;
		
		public FareCalculatorTest(double expected, int agae, String time, boolean isHoliday){
			this.expected = expected;
			this.age = age;
			this.time = time;
			this.isHoliday = isHoliday;
		}
		
	@Parameters
	public static Collection<Object[]> testParams(){
		return Arrays.asList(new Object[][]{
				{0.0, 5, "6:00", false},
				{2.5, 6, "6:00", false},
				{2.5, 64, "6:00", false},
				{0.0, 65, "6:00", false},
				{0.0, 70, "6:59", false},
				{2.5, 70, "7:00", false},
				{2.5, 70, "9:00", false},
				{0.0, 70, "9:01", false}
		});
	}
	@Test
	public void calculateFareTest() {
		
		assertEquals(expected, FareCalculator.calculateFare(age, time, isHoliday), DELTA);
	}

}
