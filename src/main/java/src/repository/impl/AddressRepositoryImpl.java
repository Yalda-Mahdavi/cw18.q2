package src.repository.impl;

import javax.persistence.EntityManager;

public class AddressRepositoryImpl {
    private EntityManager entityManager;

    public AddressRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
