package vn.edu.iuh.fit.www_lab02_week2.configs;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import vn.edu.iuh.fit.www_lab02_week2.resources.*;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RootApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(EmployeeResources.class);
        classes.add(ProductResources.class);
        classes.add(CustomerResources.class);
        classes.add(OrderResources.class);
        classes.add(OrderDetailResources.class);
        classes.add(ProductImageResources.class);
        classes.add(ProductPriceResources.class);
        return classes;
    }
}
