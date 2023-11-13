package vn.edu.iuh.fit.www_lab02_week2.services;

import vn.edu.iuh.fit.www_lab02_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab02_week2.models.Employee;
import vn.edu.iuh.fit.www_lab02_week2.models.Order;
import vn.edu.iuh.fit.www_lab02_week2.repositories.EmployeeRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository repository;

    public EmployeeServices() {
        repository = new EmployeeRepository();
    }

    public void insertEmp(Employee employee) {
        repository.insertEmp(employee);
    }

    public boolean updateEmployee(long id, Employee employee) {
        Optional<Employee> rs = repository.findbyId(id);
        if (rs.isEmpty()) {
            return false;
        }
        repository.update(employee);
        return true;
    }

    public boolean deleteEmployee(long id) {
        Optional<Employee> rs = repository.findbyId(id);
        if (rs.isPresent()) {
            repository.deleteEmployee(id);
            return true;
        }
        return false;
    }

    public Optional<Employee> findById(long id) {
        return repository.findbyId(id);
    }

    public List<Employee> getAll() {
        return repository.getAllEmp();
    }
}
