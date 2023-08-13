package src.repository.impl;

import jakarta.persistence.EntityManager;

public class AddressRepositoryImpl {
    private EntityManager em;

    public AddressRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    }
