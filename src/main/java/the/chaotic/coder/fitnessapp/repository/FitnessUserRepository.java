package the.chaotic.coder.fitnessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.chaotic.coder.fitnessapp.model.FitnessUser;

import java.util.Optional;


public interface FitnessUserRepository extends JpaRepository<FitnessUser, Long> {
    Optional<FitnessUser> findByEmail(String email);
}
