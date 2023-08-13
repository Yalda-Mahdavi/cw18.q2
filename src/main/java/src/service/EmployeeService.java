package src.service;

import src.base.service.BaseService;
import src.model.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee, Long> {
    Employee findEmployeesByPostalCode(long postalCode);
    Employee findEmployeesByTelNumber(String telNumber);
    public List<Employee> findEmployeesByCity(String city);
    List<Employee> findEmployeesByMobNumber(String mobNumber);
}
