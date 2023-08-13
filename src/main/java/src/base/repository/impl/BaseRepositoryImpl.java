package src.base.repository.impl;

import src.model.Address;
import src.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class BaseRepositoryImpl {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("dafault");
    EntityManager em = emf.createEntityManager();
    public List<Employee> findEmployeesByPostalCode(long postalCode) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Join<Employee, Address> joinAddress = root.join("addresses");

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(joinAddress.get("postalCode"), postalCode));

        TypedQuery<Employee> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
