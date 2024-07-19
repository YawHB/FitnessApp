package the.chaotic.coder.fitnessapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.aot.generate.GeneratedTypeReference;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FitnessUserMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int height;
    @ManyToOne
    @JoinColumn(name = "fitness_user_id")
   private FitnessUser fitnessUser;
}
