package src.model;

import jakarta.persistence.*;
import lombok.*;
import src.base.model.BaseEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "employee")
public class Employee extends BaseEntity<Long> {
    private String name;
    private String empCode;
    private long salary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Employee(Long id, String name, String empCode, long salary, List<Address> addresses) {
        super(id);
        this.name = name;
        this.empCode = empCode;
        this.salary = salary;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empCode='" + empCode + '\'' +
                ", salary=" + salary +
                '}';
    }
}
