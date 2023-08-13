package src.util;

import jakarta.persistence.EntityManager;
import src.repository.impl.AddressRepositoryImpl;
import src.repository.impl.EmployeeRepositoryImpl;
import src.repository.impl.PhoneNumberRepositoryImpl;
import src.service.impl.AddressServiceImpl;
import src.service.impl.EmployeeServiceImpl;
import src.service.impl.PhoneNumberServiceImpl;

public class ApplicationContext {


    private static EntityManager em;

    private static EmployeeRepositoryImpl employeeRepository;
    private static EmployeeServiceImpl employeeService;

    private static AddressRepositoryImpl addressRepository;
    private static AddressServiceImpl addressService;

    private static PhoneNumberRepositoryImpl phoneNumberRepository;
    private static PhoneNumberServiceImpl phoneNumberService;



    static {
        em = HibernateUtils.getEntityManagerFactory().createEntityManager();

        employeeRepository = new EmployeeRepositoryImpl(em);
        employeeService = new EmployeeServiceImpl(employeeRepository);

        addressRepository = new AddressRepositoryImpl(em);
        addressService = new AddressServiceImpl(addressRepository);

        phoneNumberRepository = new PhoneNumberRepositoryImpl(em);
        phoneNumberService = new PhoneNumberServiceImpl(phoneNumberRepository);
    }

    public static EmployeeServiceImpl getEmployeeService() {
        return employeeService;
    }

    public static AddressServiceImpl getAddressService() {
        return addressService;
    }

    public static PhoneNumberServiceImpl getPhoneNumService() {
        return phoneNumberService;
    }
}
