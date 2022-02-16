import entity.Car;
import service.Movable;
import service.MovableAdapter;
import service.impl.MovableAdapterImpl;

public class TaskOneMain {
    private static Movable car = new Car();
    private static MovableAdapter carAdapter = new MovableAdapterImpl(car);

    public static void main(String[] args) {
        System.out.println(car.getSpeed() + " MPH");
        System.out.println(carAdapter.getSpeed() + " KPH");
    }
}
