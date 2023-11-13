package vn.edu.iuh.fit.www_lab02_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.Query; // Import Query
import vn.edu.iuh.fit.www_lab02_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab02_week2.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction entityTransaction; // Add EntityTransaction

    public EmployeeRepository() {
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        entityTransaction = em.getTransaction(); // Initialize EntityTransaction
    }

    public void insertEmp(Employee employee) {
        entityTransaction.begin();
        em.persist(employee);
        entityTransaction.commit();
    }

    public void update(Employee employee) {
        entityTransaction.begin();
        em.merge(employee);
        entityTransaction.commit();
    }
    public void deleteEmployee(long id) {
        try {
            entityTransaction.begin();

            Query query = em.createNamedQuery("Employee.delete");
            query.setParameter("empId", id);
            query.executeUpdate();

            entityTransaction.commit();
        } catch (Exception ex) {
            entityTransaction.rollback();
            System.out.println(ex);
        }
    }

    public Optional<Employee> findbyId(long id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id=:id", Employee.class);
        query.setParameter("id", id);
        try {
            Employee emp = query.getSingleResult();
            return Optional.ofNullable(emp);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Employee> getAllEmp() {
        TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE);
        return query.getResultList();
    }
}
