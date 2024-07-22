package the.chaotic.coder.fitnessapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private LocalDate sessionDate;

    @OneToMany
    @JoinColumn(name = "session_log_id")
    private Set<ExerciseLog> exerciseLogs = new HashSet<>();

}
