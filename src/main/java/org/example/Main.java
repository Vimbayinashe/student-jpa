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

    static Dotenv dotenv = Dotenv.configure().ignoreIfMalformed().ignoreIfMissing().load();

    static Map<String, Object> configOverrides = Map.of(
            "javax.persistence.jdbc.user", dotenv.get("USERNAME"),
            "javax.persistence.jdbc.password", dotenv.get("PASSWORD")
    );

    static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Lab4", configOverrides);


    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDaoImpl(ENTITY_MANAGER_FACTORY);
//        List<Student> studentList = Default.students();
//        studentList.forEach(studentDAO::create);
//        System.out.println("Default students created!");

//        Student student = studentDAO.getById(2);
//        printStudent(student, "Student Id.2");
//        student.addPayment("5000");
//        studentDAO.update(student);
//        printStudent(student, "Student Id.2 payment updated");
//        studentDAO.delete(student);

//        List<String> programmes = studentDAO.getProgrammes();
//        System.out.println("All programmes:");
//        programmes.forEach(System.out::println);

        List<Student> students;
//        students = studentDAO.getAll();
//        printStudents(students, "All students");

//        students = studentDAO.getByName("sson");
//        printStudents(students, "Students with name like 'sson'");

//        students = studentDAO.getByProgramme("Law");
//        printStudents(students, "Students studying Law");

//        students = studentDAO.getByProgrammeAndIsActive("Law", true);
//        printStudents(students, "Active students studying law");

//        students = studentDAO.getByAge(22);
//        printStudents(students, "Students who are 22 years old");

        students = studentDAO.getByAgeInterval(22, 25);
        printStudents(students, "Students between 22 and 25 years old");

    }

    private static void printStudent(Student student, String heading) {
        System.out.println("\n" + heading);
        System.out.println(student);
    }

    private static void printStudents(List<Student> allStudents, String heading) {
        System.out.println("\n" + heading + ":");
        allStudents.forEach(System.out::println);
    }

}




