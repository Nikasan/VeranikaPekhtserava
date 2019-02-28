package hw7.entities;


import hw7.enums.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static hw7.enums.Vegetables.Cucumber;
import static hw7.enums.Vegetables.Tomato;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetalsColors {

    public static MetalsColors DEFAULT = new MetalsColors(
            Arrays.asList(Cucumber.name(), Tomato.name()),
            Arrays.asList(Nature.Water.name(), Nature.Fire.name()),
            Metals.Selen.name(),
            ColorsList.Yellow.name(),
            Odds.THREE.value,
            Even.EIGHT.value
    );

    List<String> vegetables;
    List<String> nature;
    String metal;
    String color;
    Integer odd;
    Integer even;
};
