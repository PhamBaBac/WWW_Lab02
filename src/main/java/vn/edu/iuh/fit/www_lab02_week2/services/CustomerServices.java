package vn.edu.iuh.fit.www_lab02_week2.services;

import vn.edu.iuh.fit.www_lab02_week2.models.Customer;
import vn.edu.iuh.fit.www_lab02_week2.models.Product;
import vn.edu.iuh.fit.www_lab02_week2.repositories.CustomerRepository;
import vn.edu.iuh.fit.www_lab02_week2.repositories.ProductRepository;

import java.util.List;

public class CustomerServices {
    private CustomerRepository repository;

    public CustomerServices() {
        repository = new CustomerRepository();
    }

    public List<Customer> getAll() {
        return repository.getAllCus();
    }

}
