package src.model;

import jakarta.persistence.*;
import lombok.*;
import src.base.model.BaseEntity;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "address")
public class Address extends BaseEntity<Long> {

    private long postalCode;
    private String postalAddress;
    private String city;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

    public Address(Long id, long postalCode, String postalAddress, String city, Employee employee, List<PhoneNumber> phoneNumbers) {
        super(id);
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.employee = employee;
        this.phoneNumbers = phoneNumbers;
    }
}
