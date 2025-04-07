package fr.ensai.running.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.service.AthleteService;


@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private AthleteService athleteService;

    /**
     * Get all athletes
     */
    @GetMapping("/athlete")
    public List<Athlete> allAthletes() {

        return athleteService.findAll();
    }

    /**
     * Get athletes by id
     */
    @GetMapping("/GET")
    public Athlete GET(Long id) {
        return(athleteService.findById(id));

    }

    /**
     * Deletes an athletes by id
     */
    @GetMapping("/DELETE")
    public void DELETE(Long id) {

        athleteService.deleteById(id);

    }

    /**
     * Creates an athletes
     */
    @GetMapping("/CREATE")
    public Athlete CREATE(Athlete athlete) {

        return(athleteService.save(athlete));

    }

}
