package vn.edu.iuh.fit.www_lab02_week2.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab02_week2.models.Customer;
import vn.edu.iuh.fit.www_lab02_week2.models.Product;
import vn.edu.iuh.fit.www_lab02_week2.services.CustomerServices;
import vn.edu.iuh.fit.www_lab02_week2.services.ProductServices;

import java.util.List;

@Path("/customers")
public class CustomerResources {

    private CustomerServices customerServices;

    public CustomerResources() {
        customerServices = new CustomerServices();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public Response getAll() {
        List<Customer> lst = customerServices.getAll();
        return Response.ok(lst).build();
    }

}
