package src.base.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity <ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    protected ID id;
}

