package fr.nico.projetperso.T411Reader;

import java.net.HttpURLConnection;
import java.net.URL;

import fr.nico.projetperso.T411Reader.helper.AuthentificationHelper;
import fr.nico.projetperso.T411Reader.helper.ConnectionUtil;
import fr.nico.projetperso.T411Reader.service.ResponseService;
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
     * @throws Exception 
     */
    public void testApp() throws Exception
    {
    	
    }
}
