package src.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long postalCode;
    private String postalAddress;
    private String city;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

    public Address(long postalCode, String postalAddress, String city, Employee employee, List<PhoneNumber> phoneNumbers) {
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.employee = employee;
        this.phoneNumbers = phoneNumbers;
    }
}
