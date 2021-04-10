import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.AbstractXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Validator.TemaLabValidator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssignmentTestsWBT {
    private static AbstractXMLRepo<Integer, TemaLab> assignmentRepo;

    public AssignmentTestsWBT() {
        assignmentRepo = new TemaLabXMLRepo(new TemaLabValidator(), "test_assignments.xml");
    }

    @Test
    public void addAssignment_testValidEntity() throws ValidatorException {
        TemaLab assignment = new TemaLab(4, "descriere", 10, 11);
        assertNull(assignmentRepo.save(assignment));
    }

    @Test
    public void addAssignment_NegativeWeek() {
        TemaLab assignment = new TemaLab(1, "descriere", -1, 11);
        assertThrows(ValidatorException.class, () -> assignmentRepo.save(assignment));
    }

    @Test
    public void addAssignment_NullEntity() {
        assertThrows(IllegalArgumentException.class, () -> assignmentRepo.save(null));
    }
}
