package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.dao.StudentDAO;
import org.example.impl.StudentDaoImpl;
import org.example.student.Student;
import org.example.utils.Gender;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
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

//        students = studentDAO.getByAgeInterval(22, 25);
//        printStudents(students, "Students between 22 and 25 years old");

//        students = studentDAO.getByGender(Gender.MALE);
//        printStudents(students, "Male students");

//        students = studentDAO.getActive(false);
//        printStudents(students, "Inactive students");
//
//        students = studentDAO.getByProgrammeAndGender("Medicine", Gender.FEMALE);
//        printStudents(students, "Female students studying medicine");

//        students = studentDAO.getByCredits(120);
//        printStudents(students, "Students studying courses with 120 credits.");

//        students = studentDAO.getByCreditsRange(120, 180);
//        printStudents(students, "Students studying courses between 120 and 180 credits.");

//        students = studentDAO.getAllAndOutstandingBalance();
//        printStudents(students, "Students with outstanding balances");
//
//        students =studentDAO.getOutstandingBalanceByActive(false);
//        printStudents(students, "Inactive students with outstanding balances");

//        long totalOutstandingBalance = studentDAO.getTotalOutstandingBalance();
//        System.out.println("Total outstanding balance is: " + totalOutstandingBalance + " kr.");

        

    }

    private static void printStudent(Student student, String heading) {
        System.out.println("\n" + heading);
        System.out.println(student);
    }

    private static void printStudents(List<Student> students, String heading) {
        System.out.println("\n" + heading + ":");

        if(students.isEmpty())
            System.out.println("No students found.");
        else
            students.forEach(System.out::println);
    }

}




