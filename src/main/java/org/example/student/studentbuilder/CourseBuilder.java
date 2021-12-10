package org.example.student.studentbuilder;

import org.example.student.StudentBuilder;

public interface CourseBuilder {
    CourseBuilder setProgramme(String programme, int credits);
    CourseBuilder setTuitionCost(String tuitionCost);
    StudentBuilder setTuitionPaid(String tuitionPaid);
}
