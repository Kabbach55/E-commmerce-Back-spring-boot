package ma.ecom.ecom.back.sevices;

import ma.ecom.ecom.back.entities.Product;

import java.util.List;

public interface ProductService {
    Product addNewProduct(Product product);
    Product loadProductByRef(String ref);
    List<Product> listProducts();

}
