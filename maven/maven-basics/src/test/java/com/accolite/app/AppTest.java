package com.accolite.app;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testgetdiff()
    {
    	assertEquals(3,App.getdiff(new LocalDate("2019-02-26"), new LocalDate("2019-03-01")));
    	assertEquals(4,App.getdiff(new LocalDate("2016-02-26"),new LocalDate("2016-03-01")));
    }
    
    public void testgetAMorPM()
    {
    	assertEquals("PM",App.getAMorPM(new LocalDateTime("2019-01-16T14:38:35.585")));
    	assertEquals("PM",App.getAMorPM(new LocalDateTime("2019-01-16T12:00:00.000")));
    }
    
    public void testgetday()
    {
    	assertEquals("Saturday",App.getday(new LocalDate("2019-01-26")));
    	assertEquals("Wednesday",App.getday(new LocalDate("2019-02-27")));
    }
}
