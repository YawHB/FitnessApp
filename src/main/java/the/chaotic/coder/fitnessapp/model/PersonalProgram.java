package the.chaotic.coder.fitnessapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import the.chaotic.coder.fitnessapp.enums.FitnessCategory;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalProgram {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String programTitle;
    private FitnessCategory fitnessCategory;
    private int programDuration;
    private int trainingDaysPerWeek;
    private LocalDate startDate;

    @ManyToMany(mappedBy = "personalPrograms")
    private Set<FitnessUser> fitnessUsers = new HashSet<>();

}
