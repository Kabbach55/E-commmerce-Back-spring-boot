package ma.ecom.ecom.back.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private Long productId;
    private double price;
    private double quantity;

    @ManyToOne(optional = false)
    private Cart carts;

    @Transient
    private Product product;
    @Transient
    String productDescription;


    }

