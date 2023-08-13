package src.repository.impl;

import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl {
    private EntityManager entityManager;

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
