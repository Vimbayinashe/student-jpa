package org.example.student.studentbuilder;

public interface PersonBuilder {
    PersonBuilder setName(String firstName, String lastName);
    CourseBuilder setSSN(String SSN);
}
