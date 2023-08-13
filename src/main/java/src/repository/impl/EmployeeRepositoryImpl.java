package src.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import src.model.Address;
import src.model.Employee;
import src.model.PhoneNumber;
import src.repository.EmployeeRepository;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private EntityManager em;

    public EmployeeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    @Override
    public void save(Employee employee) {
        em.persist(employee);
    }

    @Override
    public void update(Employee employee) {
        em.merge(employee);
    }

    @Override
    public void remove(Employee employee) {
        em.remove(employee);
    }

    @Override
    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee findEmployeesByPostalCode(long postalCode) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(joinAddress.get("postalCode"), postalCode));

        TypedQuery<Employee> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public Employee findEmployeesByTelNumber(String telNumber) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");
        Join<Address, PhoneNumber> joinPhoneNumber = joinAddress.join("phoneNumbers");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(joinPhoneNumber.get("telNumber"), telNumber));
        TypedQuery<Employee> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public List<Employee> findEmployeesByCity(String city) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(joinAddress.get("city"), city));
        TypedQuery<Employee> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Employee> findEmployeesByMobNumber(String mobNumber) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");
        Join<Address, PhoneNumber> joinPhoneNumber = joinAddress.join("phoneNumbers");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(joinPhoneNumber.<String>get("mobNumber"), "0912%"));
        TypedQuery<Employee> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
