package src.repository.impl;

import jakarta.persistence.EntityManager;
import src.base.repository.BaseRepositoryImpl;
import src.model.Address;
import src.repository.AddressRepository;

public class AddressRepositoryImpl extends BaseRepositoryImpl<Address, Long> implements AddressRepository {
    private EntityManager em;

    public AddressRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }
}
