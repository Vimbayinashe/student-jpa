package org.example;

import org.example.student.Student;
import org.example.student.StudentBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.example.student.Guard.ValidDouble;
import static org.example.student.Guard.ValidInteger;

public class Default {

    public static List<Student> students() {
        List<List<String >> studentDetails = getStudentDetails();
        List<Student> list = new ArrayList<>();

        studentDetails.forEach(student -> {
            if (validDetails(student))
                list.add(StudentBuilder.getBuilder()
                        .setName(student.get(0), student.get(1))
                        .setSSN(student.get(2))
                        .setContactDetails(student.get(3), student.get(4))
                        .setProgramme(student.get(5), Integer.parseInt(student.get(6)))
                        .setTuitionCost(student.get(7))
                        .setTuitionPaid(student.get(8))
                        .createStudent()
                );
        });

        return list;
    }

    private static List<List<String>> getStudentDetails() {
        return List.of(
                List.of("Almir", "Eriksson", "19860712-6979", "0550-4889051", "AlmirEriksson@jourrapide.com",
                        "Law", "240", "120000", "100000")

        );
    }

    private static boolean validDetails(List<String> student) {
        return student.size() == 9 && ValidInteger(student.get(6)) && ValidDouble(student.get(7)) && ValidDouble(student.get(8));
    }

}
