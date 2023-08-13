package src.service.impl;

import src.base.service.BaseServiceImpl;
import src.model.PhoneNumber;
import src.repository.PhoneNumberRepository;
import src.service.PhoneNumberService;

public class PhoneNumberServiceImpl extends BaseServiceImpl<PhoneNumber, Long, PhoneNumberRepository> implements PhoneNumberService {

    public PhoneNumberServiceImpl(PhoneNumberRepository repository) {
        super(repository);
    }
}
