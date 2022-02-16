package taskfour.entity;

import taskfour.entity.interfaces.FamilyInterface;

public class Dog implements FamilyInterface {

    public Dog() {
    }

    @Override
    public void makeSound() {
        System.out.println("woof!");
    }
}
