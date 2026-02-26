package az.edu.ada.wm2.lab4.repository;

import az.edu.ada.wm2.lab4.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<UUID, Product> productStorage = new HashMap<>();

    @Override
    public Product save(Product product) {
        // Auto-generate UUID if null
        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
        }

        productStorage.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return Optional.ofNullable(productStorage.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productStorage.values());
    }

    @Override
    public void deleteById(UUID id) {
        productStorage.remove(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return productStorage.containsKey(id);
    }
}