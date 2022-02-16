package service.impl;

import entity.Car;
import org.junit.jupiter.api.Test;
import service.Movable;
import service.MovableAdapter;

import static org.junit.jupiter.api.Assertions.*;

class MovableAdapterImplTest {

    @Test
    public void ConvertingMPHToKMPH() {
        Movable car = new Car();
        MovableAdapter carAdapter = new MovableAdapterImpl(car);

        assertEquals(carAdapter.getSpeed(), 431.30312, 0.00001);
    }

}