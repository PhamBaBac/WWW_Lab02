package vn.edu.iuh.fit.www_lab02_week2.dto;

import vn.edu.iuh.fit.www_lab02_week2.models.OrderDetail;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private long order_id;
    private LocalDateTime orderDate;
    private String employeeName;
    private String customerName;

    public OrderDTO() {
    }

    public OrderDTO(long order_id, LocalDateTime orderDate, String employeeName, String customerName) {
        this.order_id = order_id;
        this.orderDate = orderDate;
        this.employeeName = employeeName;
        this.customerName = customerName;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    @Override
    public String toString() {
        return "OrderDTO{" +
                "order_id=" + order_id +
                ", orderDate=" + orderDate +
                ", employeeName='" + employeeName + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
