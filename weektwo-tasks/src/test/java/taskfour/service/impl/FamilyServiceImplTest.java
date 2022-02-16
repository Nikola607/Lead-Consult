package taskfour.service.impl;

import org.junit.jupiter.api.Test;
import taskfour.entity.Family;
import taskfour.service.FamilyService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceImplTest {
    private final FamilyService familyService = new FamilyServiceImpl();

    @Test
    void printList() {
        List<Family> list = new ArrayList<>();

        list = familyService.getAllSounds(list);

        assertEquals(2, list.size());
    }
}