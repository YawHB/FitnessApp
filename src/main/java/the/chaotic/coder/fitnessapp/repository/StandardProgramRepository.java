package the.chaotic.coder.fitnessapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.chaotic.coder.fitnessapp.model.StandardProgram;

public interface StandardProgramRepository extends JpaRepository<StandardProgram, Long> {
}
