package the.chaotic.coder.fitnessapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SetLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private int setNumber;
    private int repetitionsAchieved;
    private double weightLifted;



}
