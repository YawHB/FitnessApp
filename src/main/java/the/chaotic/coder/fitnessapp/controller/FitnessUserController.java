package the.chaotic.coder.fitnessapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.chaotic.coder.fitnessapp.model.FitnessUser;
import the.chaotic.coder.fitnessapp.service.FitnessUserService;

import java.util.List;

@RestController
@RequestMapping("/fitnessusers")
public class FitnessUserController {

    private final FitnessUserService fitnessUserService;

    public FitnessUserController(FitnessUserService fitnessUserService) {
        this.fitnessUserService = fitnessUserService;
    }

//H1 Get All
    @GetMapping()
    public ResponseEntity<List<FitnessUser>>  getAllFitnessUsers() {
        return ResponseEntity.ok(fitnessUserService.getAll());
    }

    //h1 Create FitnessUser
    @PostMapping
    public ResponseEntity<FitnessUser> createFitnessUser(@RequestBody FitnessUser fitnessUser) {
        FitnessUser newFitnessUser =  fitnessUserService.addFitnessUser(fitnessUser);
        return ResponseEntity.status(201).body(newFitnessUser);


    }

}
