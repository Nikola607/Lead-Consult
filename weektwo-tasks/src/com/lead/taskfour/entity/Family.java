package taskfour.entity;

import taskfour.entity.interfaces.FamilyInterface;

public class Family<T extends FamilyInterface> {
    private T type;

    public Family(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public void printSound(){
        type.makeSound();
    }
}
