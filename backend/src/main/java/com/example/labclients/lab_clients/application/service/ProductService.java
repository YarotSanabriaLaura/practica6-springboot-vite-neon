package com.example.labclients.services;

import com.example.labclients.models.Product;
import com.example.labclients.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product productDetails) {
        return repository.findById(id).map(p -> {
            p.setName(productDetails.getName());
            p.setPrice(productDetails.getPrice());
            p.setCategory(productDetails.getCategory());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
