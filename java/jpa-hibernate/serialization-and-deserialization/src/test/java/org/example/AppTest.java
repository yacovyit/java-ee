package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;

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

    public void testPerson() throws IOException, ClassNotFoundException {
        Person person = new Person("John", "Doe", 30);

        // Test fields
        assertEquals(30, person.getAge());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());

        SerializableUtil serializableUtil = new SerializableUtil();
        String filePath = "person.ser";

        serializableUtil.serializeObject(person, filePath);

        Person deserializePerson = (Person)serializableUtil.deserializeObject(filePath);

        // test fields after deserialization
        assertEquals(person.getFirstName(), deserializePerson.getFirstName());
        assertEquals(person.getLastName(), deserializePerson.getLastName());
        assertEquals(person.getAge(), deserializePerson.getAge());

    }
}
