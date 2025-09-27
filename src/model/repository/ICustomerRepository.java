package model.repository;

import model.entity.Customer;
import model.entity.Employee;

public interface ICustomerRepository extends IRepository<Customer> {
    Customer findById(String id);
}
