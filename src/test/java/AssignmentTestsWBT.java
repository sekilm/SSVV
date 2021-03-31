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
    public void addAssigment_testValidEntity() throws ValidatorException {
        TemaLab assignment = new TemaLab(4, "descriere", 10, 11);
        assertNull(assignmentRepo.save(assignment));
    }

    @Test
    public void addAssigment_testExistingEntity() throws ValidatorException {
        TemaLab assignment = new TemaLab(4, "descriere", 10, 11);
        assignmentRepo.save(assignment);
        assert(assignmentRepo.save(assignment) == assignment);
    }
}
