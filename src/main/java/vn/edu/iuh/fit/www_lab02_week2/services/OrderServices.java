package vn.edu.iuh.fit.www_lab02_week2.services;

import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDTO;
import vn.edu.iuh.fit.www_lab02_week2.models.Customer;
import vn.edu.iuh.fit.www_lab02_week2.models.Order;
import vn.edu.iuh.fit.www_lab02_week2.repositories.CustomerRepository;
import vn.edu.iuh.fit.www_lab02_week2.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class OrderServices {
    private OrderRepository repository;

    public OrderServices() {
        repository = new OrderRepository();
    }

    public List<OrderDTO> getAll() {
        return repository.getAllOrderDTO();
    }
    public List<Order> getAllOder() {
        return repository.getAllOrder();
    }
    public List<OrderDTO> getOrdersByDate(LocalDateTime  startDate, LocalDateTime endDate) {
        return repository.getOrdersByDateRange(startDate, endDate);
    }
}
