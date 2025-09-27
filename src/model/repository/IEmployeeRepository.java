package model.repository;

import model.entity.Employee;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee> {
    Employee findById(String id);
}
