package the.chaotic.coder.fitnessapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import the.chaotic.coder.fitnessapp.model.StandardProgram;
import the.chaotic.coder.fitnessapp.repository.StandardProgramRepository;

@ExtendWith(MockitoExtension.class)
public class StandardProgramServiceTest {

    @Mock
    private StandardProgramRepository standardProgramRepository;

    @InjectMocks
    private StandardProgramService standardProgramService;



}
