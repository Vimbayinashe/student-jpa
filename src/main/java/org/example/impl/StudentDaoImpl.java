package org.example.impl;

import org.example.utils.Gender;
import org.example.dao.StudentDAO;
import org.example.student.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDAO {

    EntityManager em;

    public StudentDaoImpl(EntityManagerFactory ENTITY_MANAGER_FACTORY) {
        em = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    @Override
    public void create(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    private boolean studentExists(Student student) {
        Student student1 = getBySSN(student.getSSN());
        return student1 != null;
    }

    @Override
    public void update(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Student student) {
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    @Override
    public Student getById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public Student getBySSN(String ssn) {
        return em.createQuery("SELECT s FROM Student s WHERE s.SSN = :ssn", Student.class)
                .setParameter("ssn", ssn)
                .getSingleResult();
    }

    @Override
    public List<Student> getAll() {
        return em.createQuery("SELECT student FROM  Student student ", Student.class).getResultList();
    }

    @Override
    public List<Student> getByName(String name) {
        return em.createQuery("SELECT s FROM Student s WHERE s.firstName LIKE :name OR s.lastName LIKE :name", Student.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<Student> getByNameExact(String name) {
        return em.createQuery("SELECT s FROM Student s WHERE s.firstName = :name OR s.lastName = :name", Student.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Student> getByAge(int age) {
        return em.createQuery("SELECT s from Student s WHERE FLOOR(DATEDIFF(CURRENT_DATE, SUBSTRING(SSN, 1, 8)) / 365.25) = :age",
                Student.class)
                .setParameter("age", age)
                .getResultList();
    }

    @Override
    public List<Student> getByAgeInterval(int min, int max) {
        return em.createQuery(
                "SELECT s from Student s WHERE FLOOR(DATEDIFF(CURRENT_DATE, SUBSTRING(SSN, 1, 8)) / 365.25) " +
                "BETWEEN :min AND :max", Student.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }

    @Override
    public List<Student> getByGender(Gender gender) {
        int remainder = getRemainder(gender);
        return em.createQuery("SELECT s FROM Student s WHERE MOD(SUBSTRING(s.SSN, 12, 1), 2) = :remainder", Student.class)
                .setParameter("remainder", remainder)
                .getResultList();
    }

    private int getRemainder(Gender gender) {
        return switch (gender) {
            case MALE -> 1;
            case FEMALE -> 0;
        };
    }

    @Override
    public List<Student> getByActive(boolean active) {
        return em.createQuery("SELECT s FROM Student s WHERE s.active = :active", Student.class)
                .setParameter("active", active)
                .getResultList();
    }

    @Override
    public List<Student> getByProgramme(String programme) {
        return em.createQuery("SELECT s FROM Student s WHERE s.programme LIKE :programme", Student.class)
                .setParameter("programme", "%" + programme + "%")
                .getResultList();
    }

    @Override
    public List<Student> getByProgrammeAndIsActive(String programme, boolean active) {
        return em.createQuery("SELECT s FROM Student s WHERE s.programme = :programme AND s.active = :active", Student.class)
                .setParameter("programme", programme)
                .setParameter("active", active)
                .getResultList();
    }

    @Override
    public List<Student> getByProgrammeAndGender(String programme, Gender gender) {
        return em.createQuery("SELECT s FROM Student s WHERE s.programme = :programme AND " +
                              "MOD(SUBSTRING(s.SSN, 12, 1), 2) = :remainder", Student.class)
                .setParameter("programme", programme)
                .setParameter("remainder", getRemainder(gender))
                .getResultList();
    }

    @Override
    public List<Student> getByCredits(int credits) {
        return em.createQuery("SELECT s FROM Student s WHERE s.credits = :credits", Student.class)
                .setParameter("credits", credits)
                .getResultList();
    }

    @Override
    public List<Student> getByCreditsRange(int min, int max) {
        return em.createQuery("SELECT s FROM Student s WHERE s.credits BETWEEN :min AND :max", Student.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }

    @Override
    public List<String> getProgrammes() {
        return em.createQuery("SELECT DISTINCT (s.programme) FROM  Student s ", String.class).getResultList();
    }

    @Override
    public List<Student> getAllAndOutstandingBalance() {
        return em.createQuery("SELECT s FROM Student s WHERE s.tuitionCost - s.tuitionPaid > 0", Student.class)
                .getResultList();
    }

    @Override
    public List<Student> getOutstandingBalanceByActive(boolean active) {
        return em.createQuery(
                "SELECT s FROM Student s WHERE s.tuitionCost - s.tuitionPaid > 0 AND s.active = :active",
                    Student.class
                )
                .setParameter("active", active)
                .getResultList();
    }

    @Override
    public Map<String, String> getAllAndGroupByProgram() {
        return null;
    }

    @Override
    public Map<String, List<Student>> getOutstandingBalanceAndGroupByProgram() {
        return null;
    }

    @Override
    public Map<String, BigDecimal> getOutstandingBalanceByProgram() {
        return null;
    }

    @Override
    public Map<String, Integer> getOutstandingBalanceCountByProgram() {
        return null;
    }
}
