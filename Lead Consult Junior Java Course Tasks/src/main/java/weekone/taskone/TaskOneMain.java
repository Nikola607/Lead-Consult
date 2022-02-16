package weekone.taskone;

import weekone.taskone.entity.NumbersData;
import weekone.taskone.service.CalculationService;
import weekone.taskone.service.impl.CalculationServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TaskOneMain {
    private static final CalculationService calculationLayer = new CalculationServiceImpl();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = calculationLayer.readInput(scan);
        NumbersData numbers = calculationLayer.calculateNumbers(list);

        calculationLayer.printOutput(numbers);
    }
}
