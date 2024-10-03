package org.example;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        // Serialization is the conversion of the state of an object into a byte stream
        // Deserialization is the reverse process, converting a byte stream back into the original object
        // This is useful for persisting objects across different application instances or machines and jvm's

        Person person = new Person("John", "Doe", 30);

        SerializableUtil serializableUtil = new SerializableUtil();

        String filePath = "person.ser";

        // Serialize the object
        serializableUtil.serializeObject(person, filePath);

        // Deserialize the object
        Person deserializePerson = (Person)serializableUtil.deserializeObject(filePath);

        // Print the deserialized object
        System.out.println("Deserialized person: " + deserializePerson);
    }

}
