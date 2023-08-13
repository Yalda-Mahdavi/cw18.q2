package src.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import src.base.repository.BaseRepositoryImpl;
import src.model.Address;
import src.model.Employee;
import src.model.PhoneNumber;
import src.repository.EmployeeRepository;

import java.util.List;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee, Long> implements EmployeeRepository {

    public EmployeeRepositoryImpl(EntityManager em) {
        super(em);
    }
    @Override
    public Employee findEmployeesByPostalCode(long postalCode) {
        CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(joinAddress.get("postalCode"), postalCode));

        TypedQuery<Employee> query = getEm().createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public Employee findEmployeesByTelNumber(String telNumber) {
        CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");
        Join<Address, PhoneNumber> joinPhoneNumber = joinAddress.join("phoneNumbers");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(joinPhoneNumber.get("telNumber"), telNumber));
        TypedQuery<Employee> query = getEm().createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public List<Employee> findEmployeesByCity(String city) {
        CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(joinAddress.get("city"), city));
        TypedQuery<Employee> query = getEm().createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Employee> findEmployeesByMobNumber(String mobNumber) {
        CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");
        Join<Address, PhoneNumber> joinPhoneNumber = joinAddress.join("phoneNumbers");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(joinPhoneNumber.<String>get("mobNumber"), "0912%"));
        TypedQuery<Employee> query = getEm().createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
