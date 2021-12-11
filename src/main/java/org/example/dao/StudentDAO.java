package org.example.dao;

import org.example.utils.Gender;
import org.example.student.Student;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface StudentDAO {

    void create(Student student);

    void update(Student student);

    void delete(Student student);

    Student getById(int id);

    Student getBySSN(String ssn);

    List<String> getProgrammes();

    List<Student> getByName(String name);

    List<Student> getByNameExact(String name);

    List<Student> getByProgramme(String programme);

    List<Student> getByProgrammeAndIsActive(String programme, boolean active);

    List<Student> getAll();

    List<Student> getByAge(int age);

    List<Student> getByAgeInterval(int min, int max);

    List<Student> getByGender(Gender gender);

    List<Student> getByCredits(int credits);

    List<Student> getByCreditsRange(int min, int max);

    List<Student> getByProgrammeAndGender(String programme, Gender gender);

    List<Student> getByActive(boolean active);

    Long getTotalOutstandingBalance();

    List<Student> getAllAndOutstandingBalance();

    List<Student> getOutstandingBalanceByActive(boolean active);


    Map<String, Student>  getAllAndGroupByProgram();

    Map<String, List<Student>> getOutstandingBalanceAndGroupByProgram();

    Map<String, BigDecimal> getOutstandingBalanceByProgram();

    Map<String, Integer> getOutstandingBalanceCountByProgram(); //order DESC

  }
