package com.domain.entities.OneToManyOneDirectional;

import com.domain.entities.OneToManyOneDirectional.entity.Car;
import com.domain.entities.OneToManyOneDirectional.entity.Wheel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("many")
public class OneToManyController {
    @Autowired
    private OneToManyRepository oneToManyRepository;

    @PostMapping("save")
    public void save() {

        Map<String, String> map = new HashMap<>();

        Car car = new Car();
        car.setSpeed(10);
        car.setModel("BMW");

        Wheel wheelOne = new Wheel();
        wheelOne.setModel("G");
        wheelOne.setSize(5);

        Wheel wheelTwo = new Wheel();
        wheelTwo.setSize(5);
        wheelTwo.setModel("Z");

        List<Wheel> wheels = new ArrayList<>();
        wheels.add(wheelOne);
        wheels.add(wheelTwo);

        car.setWheels(wheels);

        oneToManyRepository.save(car);
    }

    @GetMapping("find/{id}")
    public void find(@PathVariable Long id) {
        Car car = oneToManyRepository.findCar(id);
        System.out.println(car);
    }
}
