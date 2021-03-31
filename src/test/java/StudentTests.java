import Domain.Student;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.AbstractXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Validator.StudentValidator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {
    private static AbstractXMLRepo<String, Student> studentRepo;

    public StudentTests() {
        studentRepo = new StudentXMLRepo(new StudentValidator(), "test_student.xml");
    }

    @Test
    public void testIdNotNull() throws ValidatorException {
        Student student = new Student("1", "Ionut", 934, "ionut@y.com", "");
        assertNull(studentRepo.save(student), "Student added");
    }

    @Test
    public void testIdNull() {
        Student student = new Student("", "Ionut", 934, "ionut@y.com", "");
        ValidatorException exception = assertThrows(ValidatorException.class, () -> studentRepo.save(student), "Validator Exception was thrown");

        assertTrue(exception.getMessage().contains("Id invalid\n"));
    }

    @Test
    public void testNameNotNull() throws ValidatorException {
        Student student = new Student("2", "Ionut", 934, "ionut@y.com", "");
        assertNull(studentRepo.save(student), "Student added");
    }

    @Test
    public void testNameNull() {
        Student student = new Student("3", "", 934, "ionut@y.com", "");
        ValidatorException exception = assertThrows(ValidatorException.class, () -> studentRepo.save(student), "Validator Exception was thrown");

        assertTrue(exception.getMessage().contains("Nume invalid\n"));
    }

    @Test
    public void testEmailNotNull() throws ValidatorException {
        Student student = new Student("3", "Ionut", 934, "ionut@y.com", "");
        assertNull(studentRepo.save(student), "Student added");
    }

    @Test
    public void testEmailNull() {
        Student student = new Student("4", "Ionut", 934, "", "");
        ValidatorException exception = assertThrows(ValidatorException.class, () -> studentRepo.save(student), "Validator Exception was thrown");

        assertTrue(exception.getMessage().contains("Email invalid\n"));
    }

    @Test
    public void testUniqueId() throws ValidatorException {
        Student student = new Student("4", "Ionut", 934, "ionut@y.com", "");
        assertNull(studentRepo.save(student), "Student added");
    }

    @Test
    public void testNotUniqueId() throws ValidatorException {
        Student student = new Student("4", "Ionut", 934, "ionut@y.com", "");
        studentRepo.save(student);
        assertNotNull(studentRepo.save(student), "Student already exists");
    }

    @Test
    public void testPositiveGroup() throws ValidatorException {
        Student student = new Student("3", "Ionut", 934, "ionut@y.com", "");
        assertNull(studentRepo.save(student), "Student added");
    }

    @Test
    public void testNegativeGroup() {
        Student student = new Student("4", "Ionut", -934, "ionut@y.com", "");
        ValidatorException exception = assertThrows(ValidatorException.class, () -> studentRepo.save(student), "Validator Exception was thrown");

        assertTrue(exception.getMessage().contains("Grupa invalid\n"));
    }

    @Test
    public void testGroup0() {
        Student student = new Student("4", "Ionut", 0, "ionut@y.com", "");
        ValidatorException exception = assertThrows(ValidatorException.class, () -> studentRepo.save(student), "Validator Exception was thrown");

        assertTrue(exception.getMessage().contains("Grupa invalid\n"));
    }

    @Test
    public void testGroupNegative1() {
        Student student = new Student("4", "Ionut", -1, "ionut@y.com", "");
        ValidatorException exception = assertThrows(ValidatorException.class, () -> studentRepo.save(student), "Validator Exception was thrown");

        assertTrue(exception.getMessage().contains("Grupa invalid\n"));
    }

    @Test
    public void testGroupPositive1() throws ValidatorException {
        Student student = new Student("5", "Ionut", 1, "ionut@y.com", "");
        assertNull(studentRepo.save(student), "Student added");
    }
}
