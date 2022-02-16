package weekone.taskone.service;

import weekone.taskone.entity.NumbersData;

import java.util.List;
import java.util.Scanner;

public interface CalculationService {

    NumbersData calculateNumbers(List<Integer> numbers);
    List<Integer> readInput(Scanner scan);
    void printOutput(NumbersData numbers);
}
