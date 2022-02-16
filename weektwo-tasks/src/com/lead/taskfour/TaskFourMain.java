package taskfour;

import taskfour.entity.Family;
import taskfour.service.FamilyService;
import taskfour.service.impl.FamilyServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class TaskFourMain {
    private static final FamilyService familyService = new FamilyServiceImpl();

    public static void main(String[] args) {
        List<Family> list = new ArrayList<>();
        list = familyService.getAllSounds(list);

        familyService.printList(list);
    }
}
