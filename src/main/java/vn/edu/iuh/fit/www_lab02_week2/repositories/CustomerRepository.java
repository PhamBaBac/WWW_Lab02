package vn.edu.iuh.fit.www_lab02_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab02_week2.enums.ProductStatus;
import vn.edu.iuh.fit.www_lab02_week2.models.Customer;
import vn.edu.iuh.fit.www_lab02_week2.models.Product;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;

    public CustomerRepository() {
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
    }

    public List<Customer> getAllCus() {
        return em.createNamedQuery("Customer.findAll", Customer.class)
                .getResultList();
    }

}
