package com.github.jeffreymzd.spring.boot.graphql.demo.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jeffreymzd on 3/29/21
 */
@Data
@Builder
public class SuperGroup {
    private String name;
    private Orientation orientation;
    private List<SuperCharacter> members;

    public void addToMembers(SuperCharacter newChar) {
        if (null == this.members)
            this.members = new ArrayList<>();
        if (null != newChar)
            this.members.add(newChar);
    }

    public void removeFromMembers(SuperCharacter character) {
        if (null == this.members) {
            this.members = new ArrayList<>();
            return;
        }

        if (null == character)
            return;

        this.members = this.members.stream()
                .filter(c -> !c.getName().equalsIgnoreCase(character.getName()))
                .collect(Collectors.toList());
    }
}
