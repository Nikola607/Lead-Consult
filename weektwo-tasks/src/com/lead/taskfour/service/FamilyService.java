package taskfour.service;

import taskfour.entity.Family;

import java.util.List;

public interface FamilyService {
    List<Family> getAllSounds(List<Family> outputList);
    void printList(List<Family> outputList);
}
