package weekone.tasktwo.service;

import weekone.tasktwo.entity.ArrayData;

import java.util.Scanner;

public interface ArrayCalculationService {
    int[] arrayCalculator(ArrayData arrayInput);
    ArrayData readInput(Scanner scan);
    void printOutput(int[] outputArray);

}
