package ma.ecom.ecom.back.sevices;

import ma.ecom.ecom.back.dao.ProductRepo;
import ma.ecom.ecom.back.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Override
    public Product addNewProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product loadProductByRef(String ref) {
        return productRepo.findByRef(ref);
    }

    @Override
    public List<Product> listProducts() {
        return productRepo.findAll();
    }
}
