package src.service.impl;

import src.base.service.BaseServiceImpl;
import src.model.Address;
import src.repository.AddressRepository;
import src.repository.impl.AddressRepositoryImpl;
import src.service.AddressService;

public class AddressServiceImpl  extends BaseServiceImpl<Address, Long, AddressRepository> implements AddressService {
    private AddressRepositoryImpl addressRepository;

    public AddressServiceImpl(AddressRepositoryImpl addressRepository) {
        super(addressRepository);
    }
}
