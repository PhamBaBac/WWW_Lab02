package vn.edu.iuh.fit.www_lab02_week2.dto;

import java.time.LocalDateTime;

public class OrderDetailDTO {
    private long order_id;
    private String productName;
    private double quantity;
    private double price;
    private String note;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(long order_id, String productName, double quantity, double price, String note) {
        this.order_id = order_id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "order_id=" + order_id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
