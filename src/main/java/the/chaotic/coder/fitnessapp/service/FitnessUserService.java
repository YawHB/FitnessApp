package the.chaotic.coder.fitnessapp.service;

import org.springframework.stereotype.Service;
import the.chaotic.coder.fitnessapp.exception.FitnessUserExistsException;
import the.chaotic.coder.fitnessapp.model.FitnessUser;
import the.chaotic.coder.fitnessapp.repository.FitnessUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FitnessUserService {

    private final  FitnessUserRepository fitnessUserRepository;


    public FitnessUserService(FitnessUserRepository fitnessUserRepository) {
        this.fitnessUserRepository = fitnessUserRepository;
    }

    public List<FitnessUser> getAll() {
        return fitnessUserRepository.findAll();
    }


    public FitnessUser addFitnessUser(FitnessUser fitnessUser) {

        Optional<FitnessUser> existingUser = fitnessUserRepository.findByEmail(fitnessUser.getEmail());
        if(existingUser.isPresent()) {
            throw new FitnessUserExistsException("User with name " + fitnessUser.getEmail() + " already exists");
        }
 return fitnessUserRepository.save(fitnessUser);
    }


}
