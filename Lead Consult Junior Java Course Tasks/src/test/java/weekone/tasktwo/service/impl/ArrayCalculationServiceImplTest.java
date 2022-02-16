package weekone.tasktwo.service.impl;

import org.junit.jupiter.api.Test;
import weekone.tasktwo.entity.ArrayData;
import weekone.tasktwo.service.ArrayCalculationService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceImplTest {
    private final ArrayCalculationService arrayCalculationService = new ArrayCalculationServiceImpl();
    private final ArrayData arrayData = new ArrayData();

    @Test
    public void testArrayCalculator() {
        int[] inputArray = new int[]{2, 3, -11, 7};
        arrayData.setInputArray(inputArray);
        int size = inputArray.length;
        arrayData.setSize(size);

        inputArray = arrayCalculationService.arrayCalculator(arrayData);
        int[] outputArray = new int[]{3, -9, 10, -11};

        assertEquals(Arrays.toString(outputArray), Arrays.toString(inputArray));
    }

    @Test
    public void testArrayCalculatorWrongSize() {
        int[] inputArray = new int[]{1, 2};
        arrayData.setInputArray(inputArray);
        int size = 3;
        arrayData.setSize(size);

        inputArray = arrayCalculationService.arrayCalculator(arrayData);
        int[] expectedArray = new int[]{2, 1};

        assertNotEquals(expectedArray, inputArray);
    }

    @Test
    public void testNullArrayCalculator() {
        int[] inputArray = null;
        arrayData.setInputArray(inputArray);
        int size = 3;
        arrayData.setSize(size);

        int[] expectedArray = new int[]{0};
        assertNotEquals(expectedArray, inputArray);
    }
}