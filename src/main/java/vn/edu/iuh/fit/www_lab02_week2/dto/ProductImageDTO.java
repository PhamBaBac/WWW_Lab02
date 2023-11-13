package vn.edu.iuh.fit.www_lab02_week2.dto;

public class ProductImageDTO {
    private String productName;
    private long image_id;
    private String path;
    private String alternative;

    public ProductImageDTO() {
    }

    public ProductImageDTO(String productName, long image_id, String path, String alternative) {
        this.productName = productName;
        this.image_id = image_id;
        this.path = path;
        this.alternative = alternative;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "ProductImageDTO{" +
                "productName='" + productName + '\'' +
                ", image_id=" + image_id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}
