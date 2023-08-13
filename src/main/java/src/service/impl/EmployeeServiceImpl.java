package src.service.impl;

import src.base.service.BaseServiceImpl;
import src.model.Employee;
import src.repository.EmployeeRepository;
import src.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Employee findEmployeesByPostalCode(long postalCode) {
        return getRepository().findEmployeesByPostalCode(postalCode);
    }

    @Override
    public Employee findEmployeesByTelNumber(String telNumber) {
        return getRepository().findEmployeesByTelNumber(telNumber);
    }

    @Override
    public List<Employee> findEmployeesByCity(String city) {
        return getRepository().findEmployeesByCity(city);
    }

    @Override
    public List<Employee> findEmployeesByMobNumber(String mobNumber) {
        return getRepository().findEmployeesByMobNumber(mobNumber);
    }
}
