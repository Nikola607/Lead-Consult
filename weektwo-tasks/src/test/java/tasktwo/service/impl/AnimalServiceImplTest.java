package tasktwo.service.impl;

import org.junit.jupiter.api.Test;
import tasktwo.entity.Animals;
import tasktwo.service.AnimalService;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

class AnimalServiceImplTest {
    private final AnimalService animalService = new AnimalServiceImpl();

    @Test
    public void testNullReadInput() {
        String userInput = System.lineSeparator();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputStream);

        Scanner scanner = new Scanner(System.in);

        try{
            HashMap<Animals, String> map = animalService.enterInput(scanner);
        }catch (ArrayIndexOutOfBoundsException e){
            return;
        }
    }
}