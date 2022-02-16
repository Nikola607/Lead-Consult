package taskfive.service;

import taskfive.entity.ArrayData;

import java.util.List;
import java.util.Scanner;

public interface ArrayCalculatorService {
    int[] findOddNumbers(ArrayData arrayData);

    int findFirstGreaterThan(ArrayData arrayData);

    List<Integer> calculateArray(ArrayData arrayData);

    ArrayData readInput(Scanner scan);

    void printArray(int[] array);

    void printList(List<Integer> list);

    void printBiggerNumber(int biggerNumber);
}
