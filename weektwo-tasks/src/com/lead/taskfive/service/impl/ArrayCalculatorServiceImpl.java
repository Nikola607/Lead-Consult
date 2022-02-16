package taskfive.service.impl;

import taskfive.entity.ArrayData;
import taskfive.service.ArrayCalculatorService;

import java.util.*;

public class ArrayCalculatorServiceImpl implements ArrayCalculatorService {

    @Override
    public int[] findOddNumbers(ArrayData inputData) {
        int[] oddNumbersArray = Arrays.stream(inputData.getInputArray()).filter(n -> n % 2 != 0).toArray();

        return oddNumbersArray;
    }

    @Override
    public int findFirstGreaterThan(ArrayData inputData) {
        int compareNumber = inputData.getCompareNumber();
        int biggerNumber = Arrays.stream(inputData.getInputArray()).filter(n -> n > compareNumber).findFirst().orElse(0);

        return biggerNumber;
    }

    @Override
    public List<Integer> calculateArray(ArrayData inputData) {
        int[] inputArray = inputData.getInputArray();
        List<Integer> outputList = new ArrayList<>();

        Arrays.stream(inputArray).map(number -> number /= 2)
                .forEach(outputList::add);

        return outputList;
    }

    @Override
    public ArrayData readInput(Scanner scan) {
        ArrayData inputData = new ArrayData();

        System.out.println("Enter array:");
        try {
            int[] inputArray = Arrays.stream(scan.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();
            inputData.setInputArray(inputArray);

            System.out.println("Enter a number to compare:");
            int number = Integer.parseInt(scan.nextLine());
            inputData.setCompareNumber(number);

        } catch (NumberFormatException e) {
            System.out.println("Input can't be null");
            throw  new NumberFormatException();
        }

        return inputData;
    }

    @Override
    public void printArray(int[] array) {
        if (array[0] == 0) {
            System.out.println("There are no odd numbers.");
            return;
        }
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void printList(List<Integer> list) {
        System.out.println("Array divided by 2:");
        list.forEach(number -> System.out.print(number + " "));
    }

    @Override
    public void printBiggerNumber(int biggerNumber) {
        System.out.println("Bigger number:");
        System.out.println(biggerNumber);
    }
}
