package vn.edu.iuh.fit.www_lab02_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDetailDTO;
import vn.edu.iuh.fit.www_lab02_week2.dto.ProductDTO;
import vn.edu.iuh.fit.www_lab02_week2.dto.ProductImageDTO;
import vn.edu.iuh.fit.www_lab02_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab02_week2.enums.ProductStatus;
import vn.edu.iuh.fit.www_lab02_week2.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private EntityManager em;

    public ProductRepository() {
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
    }

    public List<Product> getAllPro() {
        return em.createNamedQuery("Product.findAll", Product.class)
                .setParameter(1, ProductStatus.ACTIVE)
                .getResultList();
    }
    public List<ProductDTO> getAllProDTO() {
        List<OrderDetail> ordersDetails = em.createNamedQuery("OrderDetail.findAll", OrderDetail.class)
                .getResultList();
        List<ProductDTO> orderDetailDTOList = new ArrayList<>();

        for (OrderDetail orderDetail : ordersDetails) {
            ProductDTO dto = convertToDTO(orderDetail);
            orderDetailDTOList.add(dto);
        }

        return orderDetailDTOList;
    }
    private ProductDTO convertToDTO(OrderDetail orderDetail) {
        ProductDTO dto = new ProductDTO();

        dto.setId(orderDetail.getProduct().getProduct_id());
        dto.setProductName(orderDetail.getProduct().getDescription());
        dto.setQuantity(orderDetail.getQuantity());

        List<ProductImage> productImageList = orderDetail.getProduct().getProductImageList();
        if (!productImageList.isEmpty()) {
            dto.setPath(productImageList.get(0).getPath());
        }
        List<ProductPrice> productPrices = orderDetail.getProduct().getProductPrices();
        if (!productPrices.isEmpty()) {
            ProductPrice closestPrice = getClosestPrice(productPrices);
            dto.setPrice(closestPrice.getPrice());
        }
        else {
            dto.setPrice(orderDetail.getPrice());
        }

        return dto;
    }
    private ProductPrice getClosestPrice(List<ProductPrice> productPrices) {
        ProductPrice closestPrice = null;
        LocalDateTime currentTime = LocalDateTime.now();

        for (ProductPrice price : productPrices) {
            if (price.getPrice_date_time().isBefore(currentTime) &&
                    (closestPrice == null || price.getPrice_date_time().isAfter(closestPrice.getPrice_date_time()))) {
                closestPrice = price;
            }
        }

        return closestPrice;
    }

}
