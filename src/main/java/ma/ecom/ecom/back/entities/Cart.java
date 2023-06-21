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
    // Getter and setter for the quantity of a product item in the cart
    public int getQuantity() {
        int quantity = 0;
        for (ProductItem productItem : productItems) {
            quantity += productItem.getQuantity();
        }
        return quantity;
    }
    public Collection<ProductItem> getProductItems() {
        return productItems;
    }

    public void setQuantity(int quantity) {
        /* Vérifier si la quantité passée est valide (par exemple, si elle est supérieure à zéro) */
        if (quantity <= 0) {
            throw new IllegalArgumentException("La quantité doit être supérieure à zéro.");
        }

        /* Calculer le facteur de mise à l'échelle pour ajuster les quantités individuelles des produits dans le panier */
        int currentQuantity = getQuantity();
        double scale = quantity / (double) currentQuantity;

        /* Mettre à jour les quantités individuelles des produits dans le panier */
        for (ProductItem productItem : productItems) {
            int updatedQuantity = (int) (productItem.getQuantity() * scale);
            productItem.setQuantity(updatedQuantity);
        }
    }

}
