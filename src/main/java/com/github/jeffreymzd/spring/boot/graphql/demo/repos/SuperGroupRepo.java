package com.github.jeffreymzd.spring.boot.graphql.demo.repos;

import com.github.jeffreymzd.spring.boot.graphql.demo.models.Orientation;
import com.github.jeffreymzd.spring.boot.graphql.demo.models.SuperCharacter;
import com.github.jeffreymzd.spring.boot.graphql.demo.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jeffreymzd on 3/29/21
 */
@Slf4j
@Component
public class SuperGroupRepo {

    private List<SuperGroup> theGroups;

    public SuperGroupRepo() {
        seedGroups();
        log.info("Init SuperGroupRepo: {}", this.theGroups);
    }

    private void seedGroups() {
        this.theGroups = new ArrayList<>();
        SuperCharacter ironMan = SuperCharacter.builder()
                .id("Char11")
                .name("Iron Man")
                .age(36)
                .build();
        SuperCharacter professor = SuperCharacter.builder()
                .id("Char21")
                .name("Professor")
                .age(55)
                .build();

        SuperGroup g1 = SuperGroup.builder()
                .name("Avengers")
                .orientation(Orientation.HERO)
                .members(new ArrayList<>())
                .build();
        g1.addToMembers(ironMan);

        SuperGroup g2 = SuperGroup.builder()
                .name("X-Men")
                .orientation(Orientation.HERO)
                .members(new ArrayList<>())
                .build();
        g2.addToMembers(professor);

        this.theGroups.add(g1);
        this.theGroups.add(g2);
    }

    public List<SuperGroup> getTheGroups() {
        return theGroups;
    }

    public SuperGroup getGroupByName(String name) {
        Optional<SuperGroup> match = this.theGroups.stream()
                .filter(x -> x.getName().equals(name))
                .findAny();
        return match.orElse(null);
    }

    public SuperGroup addGroup(String name, Orientation orientation) {
        SuperGroup newGrp = SuperGroup.builder()
                .name(name)
                .orientation(orientation)
                .members(new ArrayList<>())
                .build();
        this.theGroups.add(newGrp);
        return newGrp;
    }
}
