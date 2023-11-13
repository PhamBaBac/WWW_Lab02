package vn.edu.iuh.fit.www_lab02_week2.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDTO;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDetailDTO;
import vn.edu.iuh.fit.www_lab02_week2.services.OrderDetailServices;
import vn.edu.iuh.fit.www_lab02_week2.services.OrderServices;

import java.util.List;

@Path("/orderDetails")
public class OrderDetailResources {

    private OrderDetailServices orderDetailServices;

    public OrderDetailResources() {
        orderDetailServices = new OrderDetailServices();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public Response getAll() {
        List<OrderDetailDTO> lst = orderDetailServices.getAll();
        return Response.ok(lst).build();
    }
}
