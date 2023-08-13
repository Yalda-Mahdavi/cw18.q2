package src.model;

import jakarta.persistence.*;
import lombok.*;
import src.base.model.BaseEntity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "phone_number")
public class PhoneNumber extends BaseEntity<Long> {

    private String telNumber;
    private String mobNumber;

    @ManyToOne
    private Address address;

    public PhoneNumber(Long id, String telNumber, String mobNumber, Address address) {
        super(id);
        this.telNumber = telNumber;
        this.mobNumber = mobNumber;
        this.address = address;
    }
}
