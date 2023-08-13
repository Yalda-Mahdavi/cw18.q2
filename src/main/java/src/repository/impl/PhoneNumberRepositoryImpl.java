package src.repository.impl;

import jakarta.persistence.EntityManager;
import src.base.repository.BaseRepositoryImpl;
import src.model.PhoneNumber;
import src.repository.PhoneNumberRepository;

public class PhoneNumberRepositoryImpl extends BaseRepositoryImpl<PhoneNumber, Long> implements PhoneNumberRepository {
    private EntityManager entityManager;

    public PhoneNumberRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<PhoneNumber> getEntityClass() {
        return PhoneNumber.class;
    }
}
