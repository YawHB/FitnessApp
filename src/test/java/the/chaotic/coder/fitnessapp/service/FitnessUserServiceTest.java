package the.chaotic.coder.fitnessapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import the.chaotic.coder.fitnessapp.repository.FitnessUserRepository;
import the.chaotic.coder.fitnessapp.model.FitnessUser;

import java.time.LocalDate;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static the.chaotic.coder.fitnessapp.enums.Gender.MALE;

@ExtendWith(MockitoExtension.class)
public class FitnessUserServiceTest {

    @Mock
    private FitnessUserRepository fitnessUserRepository;

    @InjectMocks
    private FitnessUserService fitnessUserService;

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

}
