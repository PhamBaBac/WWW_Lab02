package vn.edu.iuh.fit.www_lab02_week2.services;

import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDTO;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDetailDTO;
import vn.edu.iuh.fit.www_lab02_week2.repositories.OrderDetailRepository;
import vn.edu.iuh.fit.www_lab02_week2.repositories.OrderRepository;

import java.util.List;

public class OrderDetailServices {
    private OrderDetailRepository repository;

    public OrderDetailServices() {
        repository = new OrderDetailRepository();
    }

    public List<OrderDetailDTO> getAll() {
        return repository.getAllOrderDetailDTO();
    }

}
