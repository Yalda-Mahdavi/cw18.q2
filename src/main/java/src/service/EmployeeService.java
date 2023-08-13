package src.service;

import src.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void removeEmployee(Employee employee);
    Employee findEmployeeById(Long id);
    Employee findEmployeesByPostalCode(long postalCode);
    Employee findEmployeesByTelNumber(String telNumber);
    public List<Employee> findEmployeesByCity(String city);
    List<Employee> findEmployeesByMobNumber(String mobNumber);
}
