import Exceptions.ValidatorException;
import Repository.XMLFileRepository.AbstractXMLRepo;
import Repository.XMLFileRepository.NotaXMLRepo;
import Validator.NotaValidator;


import Domain.Nota;
import org.junit.Test;

import javax.xml.validation.Validator;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertNull;

public class GradeTests {
    private static NotaXMLRepo gradeRepository;

    public GradeTests() {
        gradeRepository = new NotaXMLRepo(new NotaValidator(), "tests_grade.xml");
    }

    @Test
    public void addGrade_testValidEntity() throws Exceptions.ValidatorException {
        Nota grade = new Nota(1, "1", 1, 10, LocalDateTime.of(2021,
                Month.APRIL, 29, 19, 30, 40));
        assertNull(gradeRepository.save(grade));
    }

}
