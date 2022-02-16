package taskone;

import taskone.entity.InputData;
import taskone.service.ArrayConverterService;
import taskone.service.impl.ArrayConverterServiceImpl;

import java.util.Scanner;

public class TaskOneMain {
    private static final ArrayConverterService arrayConverterService = new ArrayConverterServiceImpl();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        InputData inputData = arrayConverterService.readInput(scan);
        String[] outputArray = arrayConverterService.listToArray(inputData);

        arrayConverterService.printOutput(outputArray);
    }
}
