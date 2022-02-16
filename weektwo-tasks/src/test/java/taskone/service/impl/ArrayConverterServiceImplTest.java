package taskone.service.impl;

import org.junit.jupiter.api.Test;
import taskone.entity.InputData;
import taskone.service.ArrayConverterService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayConverterServiceImplTest {
    private final ArrayConverterService arrayConverterService = new ArrayConverterServiceImpl();
    private final InputData inputData = new InputData();

    @Test
    public void testListToArray(){
        List<String> inputList = Stream.of("1", "2", "3", "4", "5").collect(Collectors.toList());
        inputData.setList(inputList);
        String[] outputArray = arrayConverterService.listToArray(inputData);

        assertArrayEquals(inputList.toArray(), outputArray);
    }

    @Test
    public void emptyList(){
        List<String> inputList = new ArrayList<>();
        inputData.setList(inputList);
        String[] outputArray = arrayConverterService.listToArray(inputData);

        assertEquals(0, outputArray.length);
    }
}