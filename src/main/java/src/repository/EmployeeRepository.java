package src.repository;

import src.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    void update(Employee employee);
    void remove(Employee employee);
    Employee findById(Long id);
    Employee findEmployeesByPostalCode(long postalCode);
    Employee findEmployeesByTelNumber(String telNumber);
    List<Employee> findEmployeesByCity(String city);
    List<Employee> findEmployeesByMobNumber(String mobNumber);
}
