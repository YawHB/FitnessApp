package the.chaotic.coder.fitnessapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import the.chaotic.coder.fitnessapp.enums.Gender;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FitnessUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthdate;

    @OneToMany( cascade =CascadeType.ALL )
    @JoinColumn(name = "fitness_user_id")
    private List<FitnessUserMeasurement> measurements;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "fitness_user_id")
    private Set<PersonalBest> personalBests;
    private Gender gender;

    //TODO Add many to many with Program
    @ManyToMany
    @JoinTable(name = "fitnessuser_standardprogram", joinColumns = @JoinColumn(name = "fitness_user_id"), inverseJoinColumns = @JoinColumn(name = "standard_program_id"))
    private Set<StandardProgram> standardPrograms = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "fitnessuser_personalprogram", joinColumns = @JoinColumn(name = "fitness_user_id"), inverseJoinColumns = @JoinColumn(name = "personal_program_id"))
    private Set<PersonalProgram> personalPrograms = new HashSet<>();



}
