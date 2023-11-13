package vn.edu.iuh.fit.www_lab02_week2.services;

import vn.edu.iuh.fit.www_lab02_week2.dto.ProductDTO;
import vn.edu.iuh.fit.www_lab02_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab02_week2.enums.ProductStatus;
import vn.edu.iuh.fit.www_lab02_week2.models.Employee;
import vn.edu.iuh.fit.www_lab02_week2.models.Order;
import vn.edu.iuh.fit.www_lab02_week2.models.Product;
import vn.edu.iuh.fit.www_lab02_week2.repositories.EmployeeRepository;
import vn.edu.iuh.fit.www_lab02_week2.repositories.ProductRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class ProductServices {
    private ProductRepository repository;

    public ProductServices() {
        repository = new ProductRepository();
    }

    public List<Product> getAll() {
        return repository.getAllPro();
    }
    public List<ProductDTO> getProDTO() {
        return repository.getAllProDTO();
    }

}
