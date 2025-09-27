package model.service;

import model.entity.Customer;
import model.entity.Employee;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    boolean add(Customer employee);
    boolean isEditById(String id, Customer newEmployee);
    Customer findById(String id);
    boolean deleteById(String id);
}
