package taskfour.entity;

import taskfour.entity.interfaces.FamilyInterface;

public class Human implements FamilyInterface {

    public Human() {
    }

    @Override
    public void makeSound() {
        System.out.println("*complains");
    }
}
