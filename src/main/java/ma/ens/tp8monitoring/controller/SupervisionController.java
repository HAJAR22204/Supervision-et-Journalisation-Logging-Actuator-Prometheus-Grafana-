package ma.ens.tp8monitoring.controller;

import ma.ens.tp8monitoring.service.SupervisionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupervisionController {

    private final SupervisionService supervisionService;

    public SupervisionController(SupervisionService supervisionService) {
        this.supervisionService = supervisionService;
    }

    @GetMapping("/execute-task")
    public String execute() {
        return supervisionService.runDataProcessing();
    }
}
