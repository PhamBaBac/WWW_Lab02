package vn.edu.iuh.fit.www_lab02_week2.services;

import vn.edu.iuh.fit.www_lab02_week2.models.ProductPrice;
import vn.edu.iuh.fit.www_lab02_week2.repositories.ProductPriceRepository;

import java.util.List;

public class ProductPriceServices {
    private ProductPriceRepository repository;

    public ProductPriceServices() {
        repository = new ProductPriceRepository();
    }

    public List<ProductPrice> getAllPriceByProductId(Long productId) {
        return repository.getAllPriceByProductId(productId);
    }
}
