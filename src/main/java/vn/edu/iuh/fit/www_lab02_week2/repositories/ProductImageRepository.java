package vn.edu.iuh.fit.www_lab02_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDTO;
import vn.edu.iuh.fit.www_lab02_week2.dto.ProductImageDTO;
import vn.edu.iuh.fit.www_lab02_week2.enums.ProductStatus;
import vn.edu.iuh.fit.www_lab02_week2.models.Order;
import vn.edu.iuh.fit.www_lab02_week2.models.Product;
import vn.edu.iuh.fit.www_lab02_week2.models.ProductImage;

import java.util.ArrayList;
import java.util.List;

public class ProductImageRepository {
    private EntityManager em;

    public ProductImageRepository() {
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
    }

    public List<ProductImageDTO> getAllProductImageDTO() {
        List<ProductImage> productImages = em.createNamedQuery("ProductImage.findAll", ProductImage.class)
                .getResultList();
        List<ProductImageDTO> productImageDTOSToList = new ArrayList<>();

        for (ProductImage productImage : productImages) {
            ProductImageDTO dto = convertToDTO(productImage);
            productImageDTOSToList.add(dto);
        }

        return productImageDTOSToList;
    }

    private ProductImageDTO convertToDTO(ProductImage productImage) {
        ProductImageDTO dto = new ProductImageDTO();
        dto.setProductName(productImage.getProduct().getName());
        dto.setImage_id(productImage.getImage_id());
        dto.setPath(productImage.getPath());
        dto.setAlternative(productImage.getAlternative());
        return dto;
    }
}
