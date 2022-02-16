package weekone.tasktwo;

import weekone.tasktwo.entity.ArrayData;
import weekone.tasktwo.service.ArrayCalculationService;
import weekone.tasktwo.service.impl.ArrayCalculationServiceImpl;

import java.util.Scanner;

public class TaskTwoMain {
    private static final ArrayCalculationService arrayCalculatorService = new ArrayCalculationServiceImpl();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayData arrayData = arrayCalculatorService.readInput(scan);
        int[] outputArray = arrayCalculatorService.arrayCalculator(arrayData);

        arrayCalculatorService.printOutput(outputArray);
    }

}
