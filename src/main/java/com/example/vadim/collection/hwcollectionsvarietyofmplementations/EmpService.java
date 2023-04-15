package com.example.vadim.collection.hwcollectionsvarietyofmplementations;

import java.util.Collection;

public interface EmpService {
    Employee add(String name, String surname);
    Employee remove(String name, String surname);
    Employee find(String name, String surname);

    Collection<Employee> findAll();
}
