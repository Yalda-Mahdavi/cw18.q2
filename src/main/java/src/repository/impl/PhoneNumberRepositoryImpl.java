package src.repository.impl;

import javax.persistence.EntityManager;

public class PhoneNumberRepositoryImpl {
    private EntityManager entityManager;

    public PhoneNumberRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
