package tasktwo.service;

import tasktwo.entity.Animals;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface AnimalService {
    void sort(Map<Animals, String> map);

    void printOutput(Map<Animals, String> map);

    HashMap<Animals, String> enterInput(Scanner scan);
}
