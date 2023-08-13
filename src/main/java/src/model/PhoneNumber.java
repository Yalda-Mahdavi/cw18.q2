package src.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String telNumber;
    private String mobNumber;

    @ManyToOne
    private Address address;

    public PhoneNumber(String telNumber, String mobNumber, Address address) {
        this.telNumber = telNumber;
        this.mobNumber = mobNumber;
        this.address = address;
    }
}
