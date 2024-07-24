package the.chaotic.coder.fitnessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.chaotic.coder.fitnessapp.model.FitnessUser;



public interface FitnessUserRepository extends JpaRepository<FitnessUser, Long> {
}
