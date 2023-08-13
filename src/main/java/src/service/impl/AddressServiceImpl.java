package src.service.impl;

import src.repository.impl.AddressRepositoryImpl;

public class AddressServiceImpl {
    private AddressRepositoryImpl addressRepository;

    public AddressServiceImpl(AddressRepositoryImpl addressRepository) {
        this.addressRepository = addressRepository;
    }
}
