package vn.edu.iuh.fit.www_lab02_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab02_week2.models.ProductPrice;

import java.util.List;

public class ProductPriceRepository {
    private EntityManager em;

    public ProductPriceRepository() {
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
    }

    public List<ProductPrice> getAllPriceByProductId(Long productId) {
        return em.createNamedQuery("ProductPrice.getAllPriceDateTimeById", ProductPrice.class)
                .setParameter("productId", productId)
                .getResultList();
    }
}

