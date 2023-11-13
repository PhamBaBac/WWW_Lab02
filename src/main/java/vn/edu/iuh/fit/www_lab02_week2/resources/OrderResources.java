package vn.edu.iuh.fit.www_lab02_week2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab02_week2.dto.OrderDTO;
import vn.edu.iuh.fit.www_lab02_week2.models.Customer;
import vn.edu.iuh.fit.www_lab02_week2.models.Employee;
import vn.edu.iuh.fit.www_lab02_week2.models.Order;
import vn.edu.iuh.fit.www_lab02_week2.services.CustomerServices;
import vn.edu.iuh.fit.www_lab02_week2.services.OrderServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Path("/orders")
public class OrderResources {

    private OrderServices orderServices;

    public OrderResources() {
        orderServices = new OrderServices();
    }

    @GET
    @Path("all")
    @Produces("application/json")
    public Response getAll() {
        List<OrderDTO> lst = orderServices.getAll();
        return Response.ok(lst).build();
    }
    @GET
    @Path("/byDate")
    @Produces("application/json")
    public Response findByDate(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate) {
        LocalDateTime startDateTime;
        LocalDateTime endDateTime;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            startDateTime = LocalDateTime.parse(startDate + " 00:00:00", formatter);
            endDateTime = LocalDateTime.parse(endDate + " 23:59:59", formatter);
        } catch (DateTimeParseException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date format").build();
        }
        List<OrderDTO> ordersByDate = orderServices.getOrdersByDate(startDateTime, endDateTime);

        return Response.ok(ordersByDate).build();
    }
}
