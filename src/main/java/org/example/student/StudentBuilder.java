package org.example.student;

import org.example.student.studentbuilder.CourseBuilder;
import org.example.student.studentbuilder.PersonBuilder;

public class StudentBuilder implements PersonBuilder, CourseBuilder {

    private String firstName;
    private String lastName;
    private String SSN;
    private String phoneNumber;
    private String emailAddress;
    private String programme;
    private int credits;
    private String tuitionCost;
    private String tuitionPaid;

    private StudentBuilder() {

    }

    public static PersonBuilder getBuilder() {
        return new StudentBuilder();
    }

    @Override
    public PersonBuilder setName(String firstName, String lastName) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        return this;
    }

    @Override
    public CourseBuilder setSSN(String SSN) {
        this.SSN = SSN.trim();
        return this;
    }

    @Override
    public CourseBuilder setProgramme(String programme, int credits) {
        this.programme = programme.trim();
        this.credits = credits;
        return this;
    }


    @Override
    public CourseBuilder setTuitionCost(String tuitionCost) {
        this.tuitionCost = tuitionCost.trim();
        return this;
    }

    @Override
    public StudentBuilder setTuitionPaid(String tuitionPaid) {
        this.tuitionPaid = tuitionPaid.trim();
        return this;
    }

    public StudentBuilder setContactDetails(String phoneNumber, String emailAddress) {
        this.phoneNumber = phoneNumber.trim();
        this.emailAddress = emailAddress.trim();
        return this;
    }

    public Student createStudent() {
        return new Student(firstName, lastName, SSN, phoneNumber, emailAddress, programme, credits, tuitionCost, tuitionPaid);
    }

}






