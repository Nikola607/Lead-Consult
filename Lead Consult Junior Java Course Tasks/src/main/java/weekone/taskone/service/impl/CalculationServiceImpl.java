package weekone.taskone.service.impl;


import weekone.taskone.entity.NumbersData;
import weekone.taskone.service.CalculationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculationServiceImpl implements CalculationService {

    public NumbersData calculateNumbers(List<Integer> numbers) {
        NumbersData values = new NumbersData();
        if (numbers.size() > 0) {

            int largestOddNum = 0;
            int smallestNum = numbers.get(0);
            int largestNum = numbers.get(0);

            for (Integer number : numbers) {
                if (isOddNumber(largestOddNum, number)) {
                    largestOddNum = number;
                }

                if (isSmaller(smallestNum, number)) {
                    smallestNum = number;
                }

                if (isLarger(largestNum, number)) {
                    largestNum = number;
                }
            }
            values.setLargestNumber(largestNum);
            values.setSmallestNumber(smallestNum);
            values.setLargestOddNumber(largestOddNum);

        }
        return values;
    }

    private boolean isLarger(int largestNum, Integer number) {
        return number > largestNum;
    }

    private boolean isSmaller(int smallestNum, Integer number) {
        return number < smallestNum;
    }

    private boolean isOddNumber(int largestOddNum, Integer number) {
        return number % 2 != 0 && number > largestOddNum;
    }

    public List<Integer> readInput(Scanner scan) {
        List<Integer> list = new ArrayList<>();
        int num;
        System.out.println("Enter numbers:");
        try {
            while ((num = Integer.parseInt(scan.nextLine())) != 0) {
                list.add(num);
            }
        }catch (NullPointerException e){
            System.out.println("Invalid input.");
        }
        return list;
    }

    @Override
    public void printOutput(NumbersData numbers) {
        System.out.println("Largest number: " + numbers.getLargestNumber());
        System.out.println("Smallest number: " + numbers.getSmallestNumber());

        if (numbers.getLargestOddNumber() == 0) {
            System.out.println("There are no odd numbers!");
        } else {
            System.out.println("Largest odd number: " + numbers.getLargestOddNumber());
        }
    }
}
