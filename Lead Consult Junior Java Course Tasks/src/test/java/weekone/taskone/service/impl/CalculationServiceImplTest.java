package weekone.taskone.service.impl;

import org.junit.jupiter.api.Test;
import weekone.taskone.entity.NumbersData;
import weekone.taskone.service.CalculationService;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceImplTest {
    private final CalculationService calculationService = new CalculationServiceImpl();

    @Test
    public void calculateNumbers() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());

        NumbersData numbersData = calculationService.calculateNumbers(list);
        assertEquals(1, numbersData.getSmallestNumber());
        assertEquals(6, numbersData.getLargestNumber());
        assertEquals(5, numbersData.getLargestOddNumber());
    }

    @Test
    public void calculateNumbersEmpty() {
        List<Integer> list = new ArrayList<>();
        NumbersData numbersData = calculationService.calculateNumbers(list);

        assertEquals(0, numbersData.getSmallestNumber());
        assertEquals(0, numbersData.getLargestNumber());
        assertEquals(0, numbersData.getLargestOddNumber());
    }

    @Test
    public void calculateSameNumbers() {
        List<Integer> list = Stream.of(1, 1, 1, 1, 1, 1).collect(Collectors.toList());

        NumbersData numbersData = calculationService.calculateNumbers(list);
        assertEquals(1, numbersData.getSmallestNumber());
        assertEquals(1, numbersData.getLargestNumber());
        assertEquals(1, numbersData.getLargestOddNumber());
    }

    @Test
    public void readInputIsNull() {
        String userInput = System.lineSeparator();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputStream);

        Scanner scanner = new Scanner(System.in);

        try {
            List<Integer> list = calculationService.readInput(scanner);
        } catch (NumberFormatException e) {
            return;
        }
    }
}