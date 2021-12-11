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
                        "Law", "240", "120000", "100000"),
                List.of("Ebbe", "Olofsson", "19990727-0070", "044-8902518", "EbbeOlofsson@rhyta.com",
                        "Medicine", "300", "150000", "90000"),
                List.of("Sonia", "Lund", "20000612-0869", "0651-22590888", "SoniaLund@dayrep.com",
                        "Medicine", "300", "150000", "90000"),
                List.of("Alexandra", "Eliasson", "19960131-6945", "0370-3066315", "AlexsandraEliasson@jourrapide.com",
                        "Medicine", "300", "150000", "140000"),
                List.of("Gordon", "Bergström", "19980407-5137", "0515-6919619", "GordonBergstrom@jourrapide.com",
                        "Medicine", "300", "150000", "90000"),
                List.of("Caspar", "Jonasson", "19961013-4794", "040-3392667", "CasparJonasson@dayrep.com",
                        "Music", "180", "80000", "60000"),
                List.of("Angelina", "Martins", "19950206-8082 ", "0393-5343197", "AngelinaEriksson@teleworm.us",
                        "Software Development", "180", "120000", "110000"),
                List.of("Albin", "Eriksson", "20030329-5989", "0382-8391709", "AlbinaEriksson@jourrapide.com",
                        "Software Development", "180", "120000", "0"),
                List.of("Kevin", "Horst", "19990523-2775 ", "0471-8603325", "KevinIHorst@teleworm.us",
                        "Music", "180", "80000", "80000"),
                List.of("Lissa", "Herrera", "19980921-6465", "0645-3425189", "LisaNHerrera@dayrep.com",
                        "Civil Engineering", "240", "180000", "180000"),
                List.of("Charles", "Briones", "19990801-7170", "0525-4919893", "CharlesSBriones@rhyta.com",
                        "Civil Engineering", "240", "180000", "70525"),
                List.of("Patrik", "McNeal", "19970826-8799", "0973-9520949", "PatrickRMcNeal@dayrep.com",
                        "Education", "240", "120000", "20500"),
                List.of("Daniella", "Sandvik", "20021226-6228 ", "0140-7855270", "DonaldABricker@rhyta.com",
                        "Education", "240", "120000", "90995")
        );
    }

    private static boolean validDetails(List<String> student) {
        return student.size() == 9 && ValidInteger(student.get(6)) && ValidDouble(student.get(7)) && ValidDouble(student.get(8));
    }

}





