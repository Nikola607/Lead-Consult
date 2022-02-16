package tasktwo;

import tasktwo.entity.Animals;
import tasktwo.service.AnimalService;
import tasktwo.service.impl.AnimalServiceImpl;

import java.util.HashMap;
import java.util.Scanner;

public class TaskTwoMain {
    private static final AnimalService animalService = new AnimalServiceImpl();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<Animals, String> map = animalService.enterInput(scan);
        animalService.sort(map);
        animalService.printOutput(map);
    }
}
