package taskfive.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import taskfive.entity.ArrayData;
import taskfive.service.ArrayCalculatorService;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculatorServiceImplTest {
    private final ArrayCalculatorService arrayCalculatorService = new ArrayCalculatorServiceImpl();
    private final ArrayData arrayData = new ArrayData();

    @Test
    public void testFindOddNumbers() {
        int[] inputArray = new int[]{10, 20, 80, 50, 40, 3};
        arrayData.setInputArray(inputArray);

        inputArray = arrayCalculatorService.findOddNumbers(arrayData);
        int[] oddNumbersArrayExpected = new int[]{3};
        assertArrayEquals(oddNumbersArrayExpected, inputArray);
    }

    @Test
    public void testNoOddNumbers() {
        int[] inputArray = new int[]{10, 20, 80, 50, 40};
        arrayData.setInputArray(inputArray);

        inputArray = arrayCalculatorService.findOddNumbers(arrayData);
        assertEquals(0, inputArray.length);
    }

    @Test
    public void testFindGreaterThan() {
        int[] inputArray = new int[]{10, 20, 80, 50, 40, 3};
        arrayData.setInputArray(inputArray);

        int compareNumber = 40;
        arrayData.setCompareNumber(compareNumber);
        int inputNumber = arrayCalculatorService.findFirstGreaterThan(arrayData);

        assertEquals(80, inputNumber);
    }

    @Test
    public void testNoGreaterThan() {
        int[] inputArray = new int[]{10, 20, 80, 50, 40, 3};
        arrayData.setInputArray(inputArray);

        int compareNumber = 80;
        arrayData.setCompareNumber(compareNumber);

        int inputNumber = arrayCalculatorService.findFirstGreaterThan(arrayData);
        assertEquals(0, inputNumber);
    }

    @Test
    public void testCalculateArray() {
        int[] inputArray = new int[]{10, 20, 80, 50, 40, 3};
        arrayData.setInputArray(inputArray);

        List<Integer> outputList = arrayCalculatorService.calculateArray(arrayData);
        List<Integer> expectedList = Stream.of(5, 10, 40, 25, 20, 1).collect(Collectors.toList());

        assertEquals(expectedList, outputList);
    }

    @Test
    public void testNullArrayReadInput() {
        String userInput = System.lineSeparator();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputStream);

        Scanner scanner = new Scanner(System.in);

        try {
            ArrayData arrayData = arrayCalculatorService.readInput(scanner);
        } catch (NumberFormatException e) {
            return;
        }
    }
}