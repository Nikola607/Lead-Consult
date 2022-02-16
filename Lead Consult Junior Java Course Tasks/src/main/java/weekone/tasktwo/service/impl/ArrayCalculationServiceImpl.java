package weekone.tasktwo.service.impl;

import weekone.tasktwo.entity.ArrayData;
import weekone.tasktwo.service.ArrayCalculationService;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    @Override
    public int[] arrayCalculator(ArrayData arrayInput) {
        if(arrayInput.getSize() == 0 || arrayInput.getInputArray() == null){
            System.out.println("Invalid input.");

            return new int[]{0};
        }
        int[] inputArray = arrayInput.getInputArray();
        int[] outputArray = new int[inputArray.length];
        int size = arrayInput.getSize();


        if(size > inputArray.length || size < inputArray.length){
            System.out.println("Size does not match size of array.");
            return inputArray;
        }

        outputArray[0] = inputArray[1];
        outputArray[size - 1] = inputArray[size - 2];

        for (int i = 1; i < size - 1; i++) {
            outputArray[i] = inputArray[i - 1] + inputArray[i + 1];
        }

        arrayInput.setOutputArray(outputArray);

        return outputArray;
    }

    @Override
    public ArrayData readInput(Scanner scan) {
        ArrayData arrayData = new ArrayData();
        int size = 0;
        System.out.println("Enter array size:");
        try {
            size = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Size can't be null.");
        }

        arrayData.setSize(size);

        System.out.println("Enter array numbers:");
        try {
            int[] array = Arrays.stream(scan.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();

            arrayData.setInputArray(array);
        } catch (NumberFormatException e) {
            System.out.println("Array can't be null.");
        }
        return arrayData;
    }

    @Override
    public void printOutput(int[] outputArray) {
        System.out.println(Arrays.toString(outputArray));
    }
}
