package vn.edu.iuh.fit.www_lab02_week2.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab02_week2.dto.ProductImageDTO;
import vn.edu.iuh.fit.www_lab02_week2.models.Product;
import vn.edu.iuh.fit.www_lab02_week2.services.ProductImageServices;
import vn.edu.iuh.fit.www_lab02_week2.services.ProductServices;

import java.util.List;

@Path("/productImages")
public class ProductImageResources {

    private ProductImageServices productImageServices;

    public ProductImageResources() {
        productImageServices = new ProductImageServices();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public Response getAll() {
        List<ProductImageDTO> lst = productImageServices.getAll();
        return Response.ok(lst).build();
    }
}
