package the.chaotic.coder.fitnessapp.model;

import jakarta.persistence.*;
import lombok.*;
import the.chaotic.coder.fitnessapp.enums.Gender;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
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
    private Gender gender;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "fitness_user_id")
    private Set<PersonalBest> personalBests;

    //TODO Add many to many with Program
    @ManyToMany
    @JoinTable(name = "fitnessuser_standardprogram", joinColumns = @JoinColumn(name = "fitness_user_id"), inverseJoinColumns = @JoinColumn(name = "standard_program_id"))
    private Set<StandardProgram> standardPrograms = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "fitnessuser_personalprogram", joinColumns = @JoinColumn(name = "fitness_user_id"), inverseJoinColumns = @JoinColumn(name = "personal_program_id"))
    private Set<PersonalProgram> personalPrograms = new HashSet<>();


    public FitnessUser(long id, String firstName, String lastName, String email, String password, LocalDate birthdate, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
    }
}
