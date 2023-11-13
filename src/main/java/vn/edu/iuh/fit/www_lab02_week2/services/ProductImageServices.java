package vn.edu.iuh.fit.www_lab02_week2.services;

import vn.edu.iuh.fit.www_lab02_week2.dto.ProductImageDTO;
import vn.edu.iuh.fit.www_lab02_week2.models.Product;
import vn.edu.iuh.fit.www_lab02_week2.models.ProductImage;
import vn.edu.iuh.fit.www_lab02_week2.repositories.ProductImageRepository;
import vn.edu.iuh.fit.www_lab02_week2.repositories.ProductRepository;

import java.util.List;

public class ProductImageServices {
    private ProductImageRepository repository;

    public ProductImageServices() {
        repository = new ProductImageRepository();
    }

    public List<ProductImageDTO> getAll() {
        return repository.getAllProductImageDTO();
    }

}
