package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.dao.StudentDAO;
import org.example.impl.StudentDaoImpl;
import org.example.student.Student;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMalformed().ignoreIfMissing().load();

        Map<String, Object> configOverrides = Map.of(
                "javax.persistence.jdbc.user", dotenv.get("USERNAME"),
                "javax.persistence.jdbc.password", dotenv.get("PASSWORD")
        );

        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Lab4", configOverrides);

        StudentDAO studentDAO = new StudentDaoImpl(ENTITY_MANAGER_FACTORY);

        List<Student> studentList = Default.students();
        studentList.forEach(studentDAO::create);

        List<Student> allStudents = studentDAO.getAll();
        printStudents(allStudents, "All students");


    }


    private static void printStudents(List<Student> allStudents, String heading) {
        System.out.println(heading + ":");
        allStudents.forEach(System.out::println);
    }

}




