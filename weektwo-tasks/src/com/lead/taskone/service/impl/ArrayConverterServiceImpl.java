package taskone.service.impl;

import taskone.entity.InputData;
import taskone.service.ArrayConverterService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayConverterServiceImpl implements ArrayConverterService {

    @Override
    public String[] listToArray(InputData inputData) {
        if(inputData.getList().size() == 0){
            System.out.println("List is empty.");
        }
        List<String> inputList = inputData.getList();
        String[] outputArray = new String[inputList.size()];

        outputArray = inputList.toArray(outputArray);

        return outputArray;
    }

    @Override
    public InputData readInput(Scanner scan) {
        InputData inputData = new InputData();

        List<String> list = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        inputData.setList(list);

        return inputData;
    }

    @Override
    public void printOutput(String[] outputArray) {
        System.out.println("Converted array: " + Arrays.toString(outputArray));
    }
}
