package the.chaotic.coder.fitnessapp.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import the.chaotic.coder.fitnessapp.exception.FitnessUserExistsException;
import the.chaotic.coder.fitnessapp.model.FitnessUser;
import the.chaotic.coder.fitnessapp.model.StandardProgram;
import the.chaotic.coder.fitnessapp.repository.FitnessUserRepository;
import the.chaotic.coder.fitnessapp.repository.StandardProgramRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FitnessUserService {

    private final FitnessUserRepository fitnessUserRepository;
    private final StandardProgramRepository standardProgramRepository;


    public FitnessUserService(FitnessUserRepository fitnessUserRepository, StandardProgramRepository standardProgramRepository) {
        this.fitnessUserRepository = fitnessUserRepository;
        this.standardProgramRepository = standardProgramRepository;
    }

    public List<FitnessUser> getAll() {
        return fitnessUserRepository.findAll();
    }


    public FitnessUser addFitnessUser(FitnessUser fitnessUser) {

        Optional<FitnessUser> existingUser = fitnessUserRepository.findByEmail(fitnessUser.getEmail());
        if (existingUser.isPresent()) {
            throw new FitnessUserExistsException("User with name " + fitnessUser.getEmail() + " already exists");
        }
        return fitnessUserRepository.save(fitnessUser);
    }


    public ResponseEntity<FitnessUser> addStandardProgramToFitnessUser(Long userId, Long programId) {

        var user = fitnessUserRepository.findById(userId);
        var program = standardProgramRepository.findById(programId);

        if (user.isEmpty()) {
            throw new EntityNotFoundException("FitnessUser with id:  " + userId + " not found");
        }
        if (program.isEmpty()) {
            throw new EntityNotFoundException("Program with id:  " + programId + " not found");
        }

        var currentUser =  user.get();
        var currentProgram = program.get();
        Set<StandardProgram> programs =  currentUser.getStandardPrograms();
        if(programs == null)  {
             programs = new HashSet<>();
        }
         programs.add(currentProgram);
        currentUser.setStandardPrograms(programs);
         return ResponseEntity.ok( fitnessUserRepository.save(currentUser));
    }
}
