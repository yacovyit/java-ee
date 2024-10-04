package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.employee.Employee;
import org.example.employee.EmployeeRepository;
import org.example.student.Student;
import org.example.student.StudentEmbeddableId;
import org.example.student.StudentRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        /*
        Composite Primary Keys - combined primary key of two columns or more
        In hibernate there are two ways to create composite primary keys:
            1. Using @EmbeddedId annotation
            2. Using @IdClass annotation

        Rules - How to create composite key in hibernate
            1. The composite primary key class must be public.
            2. It must have a no-arg constructor.
            3. It must define the equals() and hashCode() methods.
            4, It must be Serializable.
       */


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();

            Employee employeeA = new Employee("John", "Doe",  42000);
            Employee employeeB = new Employee("Jane", "Smith", 50000);

            entityManager.persist(employeeA);
            entityManager.persist(employeeB);

            Student studentA = new Student(new StudentEmbeddableId("John", "Doe"), "Computer Science");
            Student studentB = new Student(new StudentEmbeddableId("Jane", "Smith"), "Biology");
            Student studentC = new Student(new StudentEmbeddableId("Bob", "Johnson"), "Mathematics");

            entityManager.persist(studentA);
            entityManager.persist(studentB);
            entityManager.persist(studentC);

            entityManager.getTransaction().commit();

            long numberOfEmployees = new EmployeeRepository(entityManager).countEmployeeUsingCriteriaQuery();
            System.out.println("Number of employees: " + numberOfEmployees);

            long numberOfStudents = new StudentRepository(entityManager).countStudentsUsingJPQL();
            System.out.println("Number of students: " + numberOfStudents);
        }
    }
}
