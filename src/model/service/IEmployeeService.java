package model.service;

import model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    boolean add(Employee employee);
    boolean isEditById(String id, Employee newEmployee);
    Employee findById(String id);
    boolean deleteById(String id);
}
