package vn.edu.iuh.fit.www_lab02_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDTO;
import vn.edu.iuh.fit.www_lab02_week2.models.Order;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class OrderRepository {
    private EntityManager em;

    public OrderRepository() {
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
    }
    public List<Order> getAllOrder() {
        return em.createNamedQuery("Order.findAll", Order.class)
                .getResultList();
    }
    public List<OrderDTO> getAllOrderDTO() {
        List<Order> orders = em.createNamedQuery("Order.findAll", Order.class)
                .getResultList();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (Order order : orders) {
            OrderDTO dto = convertToDTO(order);
            orderDTOList.add(dto);
        }

        return orderDTOList;
    }
    public List<OrderDTO> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Order> orders = em.createNamedQuery("Order.findByDateRange", Order.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();

        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (Order order : orders) {
            OrderDTO dto = convertToDTO(order);
            orderDTOList.add(dto);
        }

        return orderDTOList;
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setOrder_id(order.getOrder_id());
        dto.setOrderDate(order.getOrderDate());
        dto.setEmployeeName(order.getEmployee().getFullname());
        dto.setCustomerName(order.getCustomer().getName());
        return dto;
    }
}
