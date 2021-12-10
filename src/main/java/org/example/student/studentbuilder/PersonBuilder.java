package org.example.student.studentbuilder;

public interface PersonBuilder {
    PersonBuilder setName(String firstName, String lastName);

    PersonBuilder setSSN(String SSN);

    CourseBuilder setContactDetails(String phoneNumber, String emailAddress);
}
