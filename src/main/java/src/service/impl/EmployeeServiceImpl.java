package src.service.impl;

import src.model.Employee;
import src.repository.impl.EmployeeRepositoryImpl;
import src.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepositoryImpl employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.getEm().getTransaction().begin();
        employeeRepository.save(employee);
        employeeRepository.getEm().getTransaction().commit();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.getEm().getTransaction().begin();
        employeeRepository.update(employee);
        employeeRepository.getEm().getTransaction().commit();
    }

    @Override
    public void removeEmployee(Employee employee) {
        employeeRepository.getEm().getTransaction().begin();
        employeeRepository.remove(employee);
        employeeRepository.getEm().getTransaction().commit();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee findEmployeesByPostalCode(long postalCode) {
        return employeeRepository.findEmployeesByPostalCode(postalCode);
    }

    @Override
    public Employee findEmployeesByTelNumber(String telNumber) {
        return employeeRepository.findEmployeesByTelNumber(telNumber);
    }

    @Override
    public List<Employee> findEmployeesByCity(String city) {
        return employeeRepository.findEmployeesByCity(city);
    }

    @Override
    public List<Employee> findEmployeesByMobNumber(String mobNumber) {
        return employeeRepository.findEmployeesByMobNumber(mobNumber);
    }
}
