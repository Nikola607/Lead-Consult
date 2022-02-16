package taskfour.service.impl;

import taskfour.entity.Dog;
import taskfour.entity.Family;
import taskfour.entity.Human;
import taskfour.service.FamilyService;

import java.util.List;

public class FamilyServiceImpl implements FamilyService {

    @Override
    public List<Family> getAllSounds(List<Family> outputList) {
        Family<Dog> dogFamily = new Family<>(new Dog());

        Family<Human> humanFamily = new Family<>(new Human());

        outputList.add(dogFamily);
        outputList.add(humanFamily);

        return outputList;
    }

    @Override
    public void printList(List<Family> outputList) {
        outputList.forEach(Family::printSound);
    }
}
