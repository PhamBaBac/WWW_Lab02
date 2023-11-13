package vn.edu.iuh.fit.www_lab02_week2.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab02_week2.models.ProductPrice;
import vn.edu.iuh.fit.www_lab02_week2.services.ProductPriceServices;

import java.util.List;

@Path("/productPrice")
public class ProductPriceResources {

    private ProductPriceServices productPriceServices;

    public ProductPriceResources() {
        productPriceServices = new ProductPriceServices();
    }

    @GET
    @Path("/all/{productId}")
    @Produces("application/json")
    public Response getAll(@PathParam("productId") Long productId) {
        List<ProductPrice> lst = productPriceServices.getAllPriceByProductId(productId);
        return Response.ok(lst).build();
    }
}
