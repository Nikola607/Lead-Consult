package taskfive;

import taskfive.entity.ArrayData;
import taskfive.service.ArrayCalculatorService;
import taskfive.service.impl.ArrayCalculatorServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TaskFiveMain {
    private static final ArrayCalculatorService arrayCalculatorService = new ArrayCalculatorServiceImpl();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayData arrayData = arrayCalculatorService.readInput(scan);

        List<Integer> outputList = arrayCalculatorService.calculateArray(arrayData);
        int biggerNumber = arrayCalculatorService.findFirstGreaterThan(arrayData);
        int[] oddNumbersArray = arrayCalculatorService.findOddNumbers(arrayData);


        arrayCalculatorService.printArray(oddNumbersArray);
        arrayCalculatorService.printBiggerNumber(biggerNumber);
        arrayCalculatorService.printList(outputList);
    }
}
