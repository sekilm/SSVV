import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertNull;

public class IntegrationTests {
    private static Repository.XMLFileRepository.TemaLabXMLRepo assignmentRepo;
    private static Repository.XMLFileRepository.StudentXMLRepo studentRepo;
    private static Repository.XMLFileRepository.NotaXMLRepo gradeRepository;

    public IntegrationTests() {
        assignmentRepo = new Repository.XMLFileRepository.TemaLabXMLRepo(new Validator.TemaLabValidator(), "test_assignments.xml");
        studentRepo = new Repository.XMLFileRepository.StudentXMLRepo(new Validator.StudentValidator(), "test_student.xml");
        gradeRepository = new Repository.XMLFileRepository.NotaXMLRepo(new Validator.NotaValidator(), "tests_grade.xml");
    }

    @Test
    public void bigBangIntegration() throws Exceptions.ValidatorException {
        Domain.Student student = new Domain.Student("1", "Ionut", 934, "ionut@y.com", "");
        assertNull(studentRepo.save(student), "Student added");

        Domain.TemaLab assignment = new Domain.TemaLab(4, "descriere", 10, 11);
        assertNull(assignmentRepo.save(assignment));

        Domain.Nota grade = new Domain.Nota(1, "1", 4, 10, LocalDateTime.of(2021,
                Month.APRIL, 29, 19, 30, 40));
        assertNull(gradeRepository.save(grade));
    }

    @Test
    public void topDownIntegrationStudent() throws Exceptions.ValidatorException {
        Domain.Student student = new Domain.Student("2", "Daniel", 934, "daniel@y.com", "");
        assertNull(studentRepo.save(student), "Student added");
    }

    @Test
    public void topDownIntegrationAssignment() throws Exceptions.ValidatorException {
        Domain.Student student = new Domain.Student("2", "Daniel", 934, "daniel@y.com", "");
        assertNull(studentRepo.save(student), "Student added");

        Domain.TemaLab assignment = new Domain.TemaLab(6, "alta descriere", 11, 12);
        assertNull(assignmentRepo.save(assignment));
    }

    @Test
    public void topDownIntegrationGrade() throws Exceptions.ValidatorException {
        Domain.Student student = new Domain.Student("2", "Daniel", 934, "daniel@y.com", "");
        assertNull(studentRepo.save(student), "Student added");

        Domain.TemaLab assignment = new Domain.TemaLab(6, "alta descriere", 11, 12);
        assertNull(assignmentRepo.save(assignment));

        Domain.Nota grade = new Domain.Nota(2, "2", 6, 8, LocalDateTime.of(2021,
                Month.APRIL, 29, 20, 32, 42));
        assertNull(gradeRepository.save(grade));
    }
}
