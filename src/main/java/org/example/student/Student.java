package org.example.student;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String SSN;
    private String phoneNumber;
    private String emailAddress;

    private String programme;
    private int credits;    //60 credits per year

    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal tuitionCost;

    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal tuitionPaid;


    public Student() {
    }

    public Student(String firstName, String lastName, String SSN, String phoneNumber, String emailAddress,
                   String programme, int credits, String tuitionCost, String tuitionPaid) {

        //todo: add Guards


        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.programme = programme;
        this.credits = credits;
        this.tuitionCost = convertPrice(tuitionCost);
        this.tuitionPaid = convertPrice(tuitionPaid);
    }


    private BigDecimal convertPrice(String value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getProgramme() {
        return programme;
    }

    public int getCredits() {
        return credits;
    }

    public BigDecimal getTuitionCost() {
        return tuitionCost;
    }

    public BigDecimal getTuitionPaid() {
        return tuitionPaid;
    }

    public BigDecimal getOutstandingTuition() {
        return tuitionCost.subtract(tuitionPaid);
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student setSSN(String SSN) {
        this.SSN = SSN;
        return this;
    }

    public Student setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Student setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Student setProgramme(String programme) {
        this.programme = programme;
        return this;
    }

    public Student setCredits(int credits) {
        this.credits = credits;
        return this;
    }

    public Student setTuitionCost(BigDecimal tuitionCost) {
        this.tuitionCost = tuitionCost;
        return this;
    }

    public Student setTuitionPaid(BigDecimal tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && credits == student.credits && Objects.equals(firstName, student.firstName) &&
               Objects.equals(lastName, student.lastName) && Objects.equals(SSN, student.SSN) &&
               Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(emailAddress, student.emailAddress) &&
               Objects.equals(programme, student.programme) && Objects.equals(tuitionCost, student.tuitionCost) &&
               Objects.equals(tuitionPaid, student.tuitionPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, SSN, phoneNumber, emailAddress, programme, credits, tuitionCost, tuitionPaid);
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", SSN='" + SSN + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", emailAddress='" + emailAddress + '\'' +
               ", programme='" + programme + '\'' +
               ", credits=" + credits +
               ", tuitionCost=" + tuitionCost +
               ", tuitionPaid=" + tuitionPaid +
               '}';
    }
}
