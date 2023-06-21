package ma.ecom.ecom.back.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String ref;
    @Column(unique = true)
    private String description;
    private double price;
    private int stock;

    public Product(Object o, String p1, String s, int i) {
    }
}
