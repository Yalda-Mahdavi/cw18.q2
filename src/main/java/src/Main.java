package src;

import src.model.Address;
import src.model.Employee;
import src.model.PhoneNumber;
import src.service.EmployeeService;
import src.util.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args )
    {
        EmployeeService empService = ApplicationContext.getEmployeeService();
        ApplicationContext.getAddressService();
        ApplicationContext.getPhoneNumService();

        Employee employee = new Employee();
        employee.setName("Ahmad");
        employee.setSalary(100L);
        employee.setEmpCode("0031");

        List<PhoneNumber> phoneNums = new ArrayList<>();

        Address address1 = new Address(198L, "P address1", "Tehran", employee, phoneNums);
        PhoneNumber phoneNum1 = new PhoneNumber("021", "0910", address1);

        phoneNums.add(phoneNum1);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);

        employee.setAddresses(addresses);

        empService.save(employee);
//        empService.removeEmployee(empService.findEmployeeById(2L));

        System.out.println(empService.findEmployeesByPostalCode(198L));
        System.out.println(empService.findEmployeesByTelNumber("021"));
        System.out.println("Employees in Tehran: " + empService.findEmployeesByCity("Tehran"));
    }
}
