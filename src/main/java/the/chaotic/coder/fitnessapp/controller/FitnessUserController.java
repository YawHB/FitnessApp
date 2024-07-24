package the.chaotic.coder.fitnessapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.chaotic.coder.fitnessapp.model.FitnessUser;
import the.chaotic.coder.fitnessapp.service.FitnessUserService;

import java.util.List;

@RestController
@RequestMapping("/fitnessuser")
public class FitnessUserController {

    private final FitnessUserService fitnessUserService;

    public FitnessUserController(FitnessUserService fitnessUserService) {
        this.fitnessUserService = fitnessUserService;
    }


    @GetMapping()
    public ResponseEntity<List<FitnessUser>>  getAllFitnessUsers() {
        return ResponseEntity.ok(fitnessUserService.getAll());
    }

    @PostMapping
    public FitnessUser createFitnessUser(@RequestBody FitnessUser fitnessUser) {

        return fitnessUserService.addFitnessUser(fitnessUser);

    }

}
