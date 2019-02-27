package hw7.entities;


import hw7.enums.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static hw7.enums.Vegetables.Cucumber;
import static hw7.enums.Vegetables.Tomato;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class MetalsColors {

    List<String> vegetables = Stream.of(Cucumber.name(), Tomato.name()).collect(Collectors.toList());
    List<String> nature = Stream.of(Nature.Water.name(), Nature.Fire.name()).collect(Collectors.toList());
    String metal = Metals.Selen.name();
    String color = ColorsList.Yellow.name();

    Map<String,Integer> odd = new HashMap<String,Integer>(){
        {
            put(Odds.THREE.odds, Odds.THREE.value);
        }

    };
    Map<String,Integer> even = new HashMap<String,Integer>(){
        {
            put(Even.EIGHT.even, Even.EIGHT.val);
        }

    };



}
