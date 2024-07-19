package the.chaotic.coder.fitnessapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import the.chaotic.coder.fitnessapp.enums.Gender;

import java.time.LocalDate;
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

    @OneToMany(mappedBy = "fitnessUser", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<FitnessUserMeasurement> measurements;

    @OneToMany(mappedBy = "fitnessUser", cascade = CascadeType.REMOVE)
    private Set<PersonalBest> personalBests;
    private Gender gender;





}
