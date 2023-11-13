package vn.edu.iuh.fit.www_lab02_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDTO;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDetailDTO;
import vn.edu.iuh.fit.www_lab02_week2.models.Order;
import vn.edu.iuh.fit.www_lab02_week2.models.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailRepository {
    private EntityManager em;

    public OrderDetailRepository() {
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
    }

    public List<OrderDetailDTO> getAllOrderDetailDTO() {
        List<OrderDetail> ordersDetails = em.createNamedQuery("OrderDetail.findAll", OrderDetail.class)
                .getResultList();
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();

        for (OrderDetail orderDetail : ordersDetails) {
            OrderDetailDTO dto = convertToDTO(orderDetail);
            orderDetailDTOList.add(dto);
        }

        return orderDetailDTOList;
    }
    private OrderDetailDTO convertToDTO(OrderDetail orderDetail) {
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setOrder_id(orderDetail.getOrder().getOrder_id());
        dto.setProductName(orderDetail.getProduct().getName());
        dto.setQuantity(orderDetail.getQuantity());
        dto.setPrice(orderDetail.getPrice());
        dto.setNote(orderDetail.getNote());
        return dto;
    }
}
