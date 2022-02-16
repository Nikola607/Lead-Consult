package taskone.service;

import taskone.entity.InputData;

import java.util.Scanner;

public interface ArrayConverterService {
    String[] listToArray(InputData inputData);

    InputData readInput(Scanner scan);

    void printOutput(String[] outputArray);
}
