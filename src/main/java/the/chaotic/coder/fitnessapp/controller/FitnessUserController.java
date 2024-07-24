package the.chaotic.coder.fitnessapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<FitnessUser> getAllFitnessUsers() {
        return fitnessUserService.getAll();
    }

    @PostMapping
    public FitnessUser createFitnessUser(FitnessUser fitnessUser) {

        return fitnessUserService.addFitnessUser(fitnessUser);

    }

}
