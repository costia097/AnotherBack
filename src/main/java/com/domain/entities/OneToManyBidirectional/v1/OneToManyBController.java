package com.domain.entities.OneToManyBidirectional.v1;

import com.domain.entities.OneToManyBidirectional.v1.entity.Planet;
import com.domain.entities.OneToManyBidirectional.v1.entity.SolarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("many")
public class OneToManyBController {
    @Autowired
    private OneToManyBRepository oneToManyBRepository;

    @PostMapping("/b/save")
    public void save() {
        SolarSystem solarSystem = new SolarSystem();
        solarSystem.setName("SunSystem");

        Planet planetA = new Planet();
        planetA.setAge(123);
        planetA.setName("GG");
        planetA.setSize("small");
        planetA.setSolarSystem(solarSystem);


        Planet planetB = new Planet();
        planetB.setAge(1233);
        planetB.setName("AA");
        planetB.setSize("big");
        planetB.setSolarSystem(solarSystem);

        List<Planet> planets = new ArrayList<>();
        planets.add(planetA);
        planets.add(planetB);

        solarSystem.setPlanets(planets);

        oneToManyBRepository.save(solarSystem);
    }

    @GetMapping("/b/find")
    public void find() {
        Planet planet = oneToManyBRepository.find();
        SolarSystem solarSystem = planet.getSolarSystem();
        System.out.println(planet);
        System.out.println(solarSystem);
    }
}
