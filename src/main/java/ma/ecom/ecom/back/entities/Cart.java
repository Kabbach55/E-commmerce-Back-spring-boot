package ma.ecom.ecom.back.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "carts")
    private Collection<ProductItem> productItems;
    private Long userId;
    @Transient
    private User user;
}
