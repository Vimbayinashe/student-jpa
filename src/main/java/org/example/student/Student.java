package org.example.student;

import org.hibernate.id.GUIDGenerator;

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
    private boolean active;

    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal tuitionCost;

    @Convert(converter = BigDecimalConverter.class)
    private BigDecimal tuitionPaid;

    protected Student() {
    }

    protected Student(String firstName, String lastName, String SSN, String phoneNumber, String emailAddress,
                   String programme, int credits, String tuitionCost, String tuitionPaid) {

        Guard.Against.EmptyString("firstName", firstName);
        Guard.Against.EmptyString("lastName", lastName);
        Guard.Against.EmptyString("SSN", SSN);
        Guard.Against.EmptyString("programme", programme);
        Guard.Against.InvalidCredits(credits);
        Guard.Against.InvalidTuitionFormat(tuitionCost);
        Guard.Against.InvalidTuitionFormat(tuitionPaid);
        Guard.Against.InvalidSSN(SSN);

        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.programme = programme;
        this.credits = credits;
        this.active = true;
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

    private Student setTuitionCost(BigDecimal tuitionCost) {
        this.tuitionCost = tuitionCost;
        return this;
    }

    public Student increaseTuition(String tuitionCost) {
        Guard.Against.InvalidTuitionFormat(tuitionCost);
        this.tuitionCost = this.tuitionCost.add((convertPrice(tuitionCost)));
        return this;
    }

    private Student setTuitionPaid(BigDecimal tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
        return this;
    }

    public Student addPayment(String tuitionPaid) {
        Guard.Against.InvalidTuitionFormat(tuitionPaid);
        this.tuitionPaid = this.tuitionPaid.add(convertPrice(tuitionPaid));
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Student setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && credits == student.credits && active == student.active && Objects.equals(firstName
                , student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(SSN,
                student.SSN) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(emailAddress,
                student.emailAddress) && Objects.equals(programme, student.programme) && Objects.equals(tuitionCost,
                student.tuitionCost) && Objects.equals(tuitionPaid, student.tuitionPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, SSN, phoneNumber, emailAddress, programme, credits, active, tuitionCost, tuitionPaid);
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
               ", active=" + active +
               ", tuitionCost=" + tuitionCost +
               ", tuitionPaid=" + tuitionPaid +
               '}';
    }
}
