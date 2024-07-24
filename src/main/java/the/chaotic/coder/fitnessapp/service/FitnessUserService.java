package the.chaotic.coder.fitnessapp.service;

import org.springframework.stereotype.Service;
import the.chaotic.coder.fitnessapp.model.FitnessUser;
import the.chaotic.coder.fitnessapp.repository.FitnessUserRepository;

import java.util.List;

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
        return fitnessUserRepository.save(fitnessUser);
    }


}
