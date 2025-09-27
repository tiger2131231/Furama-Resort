package model.service;

import model.entity.Customer;
import model.entity.Employee;
import model.repository.CustomerRepository;
import model.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private final ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean add(Customer employee) {
        return customerRepository.add(employee);
    }

    @Override
    public boolean isEditById(String id, Customer newCustomer) {
        return customerRepository.isEditById(id, newCustomer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        return customerRepository.deleteById(id);
    }
}
