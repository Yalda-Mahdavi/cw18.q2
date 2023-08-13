package src.repository;

import src.base.repository.BaseRepository;
import src.model.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    Employee findEmployeesByPostalCode(long postalCode);
    Employee findEmployeesByTelNumber(String telNumber);
    List<Employee> findEmployeesByCity(String city);
    List<Employee> findEmployeesByMobNumber(String mobNumber);
}
