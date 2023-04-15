package com.example.vadim.collection.hwcollectionsvarietyofmplementations;

import com.example.vadim.collection.hwcollectionsvarietyofmplementations.exception.EmployeeAlreadyAddedException;
import com.example.vadim.collection.hwcollectionsvarietyofmplementations.exception.EmployeeNotFoundException;
import com.example.vadim.collection.hwcollectionsvarietyofmplementations.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpServiceImp implements EmpService{
    private final Map<String,Employee> employees;

    public EmpServiceImp(List<Employee> employees) {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String name, String surname) {
        if (employees.size() >= 10) {
            throw new EmployeeStorageIsFullException("Нельзя добавить работника, привышен придел");
        }
        Employee employee = new Employee(name, surname);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee remove(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
