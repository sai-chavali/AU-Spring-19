package com.springMVC.bowling;

import org.junit.Test;

import junit.framework.TestCase;

public class TestApp 
    extends TestCase
{
	 App sut = new App();

	    @Test
	    public void gutter_test() {
	        rollMany(20, 0);
	        assertEquals(sut.finalScore(), 0);
	    }

	    @Test
	    public void test_single_pin() {
	        sut.roll(1);
	        rollMany(19, 0);
	        assertEquals(sut.finalScore(), 1);
	    }

	    @Test
	    public void test_spare() {
	        rollSpare();
	        sut.roll(1);
	        rollMany(17, 0);
	        assertEquals(sut.finalScore(), 12);
	    }

	    @Test
	    public void test_strike() {
	        rollStrike();
	        sut.roll(4);
	        sut.roll(3);
	        rollMany(16, 0);
	        assertEquals(sut.finalScore(), 24);
	    }

	    @Test
	    public void test_perfect_App() {
	        rollMany(12, 10);
	        assertEquals(sut.finalScore(), 300);
	    }

	    private void rollMany(int numRolls, int pins) {
	        for (int i = 0; i < numRolls; i++) {
	            sut.roll(pins);
	        }
	    }

	    private void rollStrike() {
	        sut.roll(10);
	    }

	    private void rollSpare() {
	        sut.roll(6);
	        sut.roll(4);
	    }  
}
