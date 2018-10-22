package com.domain.entities.oneToOneOneDirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("one")
public class OneToOneController {
    @Autowired
    private OneToOneOneRepository oneToOneOneRepository;

    @PostMapping("save")
    public void save() {
        Human human = new Human();
        human.setName("Name");

        Heart heart = new Heart();
        heart.setPrice(100);

        human.setHeart(heart);

        oneToOneOneRepository.save(human, heart);
    }

    @GetMapping("/find/{id}")
    public Human find(@PathVariable Long id) {
        return oneToOneOneRepository.getById(id);
    }
}
