package the.chaotic.coder.fitnessapp.service;

import org.springframework.stereotype.Service;
import the.chaotic.coder.fitnessapp.model.StandardProgram;
import the.chaotic.coder.fitnessapp.repository.StandardProgramRepository;

import java.util.List;

@Service
public class StandardProgramService {

    private final StandardProgramRepository standardProgramRepository;

    public StandardProgramService(StandardProgramRepository standardProgramRepository) {
        this.standardProgramRepository = standardProgramRepository;
    }

    public List<StandardProgram> getAll() {
        return standardProgramRepository.findAll();
    }
}
