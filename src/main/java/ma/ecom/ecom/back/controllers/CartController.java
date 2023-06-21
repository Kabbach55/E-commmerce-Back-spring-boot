package ma.ecom.ecom.back.controllers;

import ma.ecom.ecom.back.dao.CartRepo;
import ma.ecom.ecom.back.dao.ProductRepo;
import ma.ecom.ecom.back.entities.Cart;
import ma.ecom.ecom.back.entities.Product;
import ma.ecom.ecom.back.entities.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import ma.ecom.ecom.back.entities.Product;


@RestController
@CrossOrigin("*")
public class CartController {

    private final CartRepo cartRepo;
    private final ProductRepo productRepo;

    @Autowired
    public CartController(CartRepo cartRepo, ProductRepo productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    @PostMapping("/cart/addProduct")
    public void addProductToCart(@RequestParam Long cartId, @RequestParam Long productId, @RequestParam int quantity) {

        Optional<Cart> optionalCart = cartRepo.findById(cartId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();

            /* Créer un nouvel objet ProductItem */
            ProductItem productItem = new ProductItem();
            productItem.setProductId(productId);
            productItem.setQuantity(quantity);

            /* Ajouter le ProductItem au panier */
            cart.getProductItems().add(productItem);

            /* Enregistrer les modifications du panier */
            cartRepo.save(cart);
        } else {
            // Gérer le cas où le panier n'est pas trouvé

        }
    }
    @GetMapping("/cart/{cartId}")
    public Cart getCart(@PathVariable Long cartId) {
        return cartRepo.findById(cartId).orElse(null);
    }

    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public Cart removeItemFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        Cart cart = cartRepo.findById(cartId).orElse(null);

        if (cart == null) {
            throw new IllegalArgumentException("Le panier est introuvable.");
        }

        // Supprimer l'élément de produit correspondant du panier
        cart.getProductItems()
                .removeIf(item -> item.getProduct().getId().equals(productId));

        return cartRepo.save(cart);
    }

    // Autres méthodes et fonctionnalités du panier (valider la commande, vider le panier, etc.)

}
