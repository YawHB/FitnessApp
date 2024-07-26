package the.chaotic.coder.fitnessapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import the.chaotic.coder.fitnessapp.model.StandardProgram;
import the.chaotic.coder.fitnessapp.service.StandardProgramService;

import java.util.List;

@RestController
@RequestMapping("/standardprograms")
public class StandardProgramController {

    private final StandardProgramService standardProgramService;

    public StandardProgramController(StandardProgramService standardProgramService) {
        this.standardProgramService = standardProgramService;
    }


@GetMapping
    public ResponseEntity<List<StandardProgram>> getAllStandardPrograms() {
        return ResponseEntity.ok(standardProgramService.getAll());
    }

}
