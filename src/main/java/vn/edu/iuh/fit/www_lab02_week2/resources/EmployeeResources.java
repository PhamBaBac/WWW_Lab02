package vn.edu.iuh.fit.www_lab02_week2.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab02_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab02_week2.models.Employee;
import vn.edu.iuh.fit.www_lab02_week2.services.EmployeeServices;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResources {

    private EmployeeServices employeeServices;

    public EmployeeResources() {
        employeeServices = new EmployeeServices();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public Response getAll() {
        List<Employee> lst = employeeServices.getAll();
        return Response.ok(lst).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") long id) {
        Optional<Employee> employee = employeeServices.findById(id);
        if (employee.isEmpty()) {
            return Response.status(404).entity("{\"message\": \"Employee not found\"}").build();
        }
        return Response.ok(employee.get()).build();
    }

    @POST
    @Path("/insert")
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee) {
        employeeServices.insertEmp(employee);
        return Response.status(Response.Status.CREATED).entity(employee).build();
    }

    @PUT
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(@PathParam("id") long id, Employee employee) {
        boolean result = employeeServices.updateEmployee(id, employee);
        if (!result) {
            return Response.status(404).entity("{\"message\": \"Employee not found\"}").build();
        }

        return Response.ok().entity("{\"message\": \"Update employee successfully\"}").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        boolean result = employeeServices.deleteEmployee(id);
        if (!result) {
            return Response.status(404).entity("{\"message\": \"Employee not found\"}").build();
        }

        return Response.ok().entity("{\"message\": \"Delete employee successfully\"}").build();
    }
}
