package model.service;

import model.entity.Employee;
import model.repository.EmployeeRepository;
import model.repository.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean add(Employee employee) {
        return employeeRepository.add(employee);
    }


    @Override
    public boolean isEditById(String id, Employee newEmployee) {
        return employeeRepository.isEditById(id, newEmployee);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        return  employeeRepository.deleteById(id);
    }
}
