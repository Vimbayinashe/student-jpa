package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.student.Student;
import org.example.student.StudentBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;


public class App {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().ignoreIfMalformed().ignoreIfMissing().load();

        Map<String, Object> configOverrides = Map.of(
                "javax.persistence.jdbc.user", dotenv.get("USERNAME"),
                "javax.persistence.jdbc.password", dotenv.get("PASSWORD")
        );

        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Lab4", configOverrides);

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        // testing database
        em.getTransaction().begin();

        Student student = StudentBuilder.getBuilder()
                .setName("Elizabeth", "Adams")
                .setSSN("19860712-6979")
                .setProgramme("Law", 240)
                .setTuitionCost("120000")
                .setTuitionPaid("100000")
                .createStudent();

        em.persist(student);
        em.getTransaction().commit();
        em.close();

    }

}
