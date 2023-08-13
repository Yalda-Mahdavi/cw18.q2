package src.repository.impl;

import jakarta.persistence.EntityManager;

public class PhoneNumberRepositoryImpl {
    private EntityManager entityManager;

    public PhoneNumberRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
