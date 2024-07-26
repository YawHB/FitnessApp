package the.chaotic.coder.fitnessapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import the.chaotic.coder.fitnessapp.model.StandardProgram;
import the.chaotic.coder.fitnessapp.repository.FitnessUserRepository;
import the.chaotic.coder.fitnessapp.model.FitnessUser;
import the.chaotic.coder.fitnessapp.repository.StandardProgramRepository;

import java.time.LocalDate;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static the.chaotic.coder.fitnessapp.enums.Gender.MALE;

@ExtendWith(MockitoExtension.class)
public class FitnessUserServiceTest {

    @Mock
    private FitnessUserRepository fitnessUserRepository;
    @Mock
    private StandardProgramRepository standardProgramRepository;



    @Test
    public void createFitnessUser() {
        //Arrange
        FitnessUser user = FitnessUser.builder()
                .firstName("James")
                .lastName("Bond")
                .email("jbond@mail.com")
                .password("007")
                .birthdate(LocalDate.of(1977, 12, 9))
                .gender(MALE)
                .build();
        when(fitnessUserRepository.save(user)).thenReturn(user);

        //Act
        FitnessUser savedUser = fitnessUserRepository.save(user);

        //Assert
        assertNotNull(savedUser);
    }

    @Test
    public void addStandardProgramToUser() {
        // Arrange
        FitnessUser user = FitnessUser.builder()
                .firstName("James")
                .lastName("Bond")
                .email("jbond@mail.com")
                .password("007")
                .birthdate(LocalDate.of(1977, 12, 9))
                .gender(MALE)
                .build();

        StandardProgram mockProgram = StandardProgram.builder()
                .Id(3L)
                .programTitle("Mock Program")
                .build();

        when(standardProgramRepository.findById(3L)).thenReturn(Optional.of(mockProgram));

        // Act
        var program = standardProgramRepository.findById(3L);
        StandardProgram existingProgram = null;
        if (program.isPresent()) {
            existingProgram = program.get();

            Set<StandardProgram> programs = user.getStandardPrograms();
            if (programs == null) {
                programs = new HashSet<>();
            }

            programs.add(existingProgram);
            user.setStandardPrograms(programs);
        }

        // Assert
        assertNotNull(user.getStandardPrograms());
        assertTrue(user.getStandardPrograms().contains(existingProgram));
    }

}
