package tasktwo.service.impl;

import tasktwo.entity.Animals;
import tasktwo.service.AnimalService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnimalServiceImpl implements AnimalService {

    @Override
    public void sort(Map<Animals, String> map) {
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey());
    }

//Dog Domestic
//Cat Domestic
//Cow Livestock
//Sheep Livestock

    @Override
    public void printOutput(Map<Animals, String> map) {
        map.entrySet().forEach(e -> System.out.println(e.getKey().getName() + " " + e.getValue()));
    }

    @Override
    public HashMap<Animals, String> enterInput(Scanner scan) {
        HashMap<Animals, String> map = new HashMap<>();
        try {
            for (int i = 1; i <= 4; i++) {
                Animals animal = new Animals();
                String[] values = scan.nextLine().split(" ");

                animal.setName(values[0]);
                animal.setType(values[1]);

                map.put(animal, animal.getType());
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Input can't be null.");
            throw new ArrayIndexOutOfBoundsException();
        }

        return map;
    }
}
