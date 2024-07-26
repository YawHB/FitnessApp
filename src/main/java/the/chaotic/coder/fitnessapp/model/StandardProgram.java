package the.chaotic.coder.fitnessapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import the.chaotic.coder.fitnessapp.enums.FitnessCategory;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String programTitle;
    @Enumerated(EnumType.STRING)
    private FitnessCategory fitnessCategory;
    private int programDuration;
    private int trainingDaysPerWeek;
    private LocalDate startDate;

    //TODO Add many to many with FitnessUser
    @ManyToMany(mappedBy = "standardPrograms")
    private Set<FitnessUser> fitnessUsers = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "standard_program_exercise",
            joinColumns = @JoinColumn(name = "standard_program_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private Set<Exercise> exercises = new HashSet<>();

@OneToMany
    @JoinColumn(name = "standard_program_id")
    private Set<SessionLog> sessionLogs = new HashSet<>();

}
