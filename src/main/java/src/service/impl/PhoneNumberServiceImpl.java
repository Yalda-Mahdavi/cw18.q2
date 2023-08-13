package src.service.impl;

import src.repository.impl.PhoneNumberRepositoryImpl;

public class PhoneNumberServiceImpl {
    private PhoneNumberRepositoryImpl phoneNumberRepository;

    public PhoneNumberServiceImpl(PhoneNumberRepositoryImpl phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }
}
