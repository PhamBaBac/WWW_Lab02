package vn.edu.iuh.fit.www_lab02_week2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab02_week2.dto.ProductDTO;
import vn.edu.iuh.fit.www_lab02_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab02_week2.models.Employee;
import vn.edu.iuh.fit.www_lab02_week2.models.Product;
import vn.edu.iuh.fit.www_lab02_week2.services.EmployeeServices;
import vn.edu.iuh.fit.www_lab02_week2.services.ProductServices;

import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductResources {

    private ProductServices productServices;

    public ProductResources() {
        productServices = new ProductServices();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public Response getAll() {
        List<Product> lst = productServices.getAll();
        return Response.ok(lst).build();
    }
    @GET
    @Path("dto/all")
    @Produces("application/json")
    public Response getProDTO() {
        List<ProductDTO> lst = productServices.getProDTO();
        return Response.ok(lst).build();
    }
}
