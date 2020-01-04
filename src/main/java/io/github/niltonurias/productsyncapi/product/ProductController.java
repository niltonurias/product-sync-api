package io.github.niltonurias.productsyncapi.product;

import io.github.niltonurias.productsyncapi.product.model.Product;
import io.github.niltonurias.productsyncapi.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable String id) {
        return this.repository.findById(id).orElse(null);
    }

    @PostMapping
    public Product insert(@RequestBody Product product) {
        product.setId(UUID.randomUUID().toString());
        this.repository.save(product);
        return product;
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable String id) {
        this.repository.findById(id).ifPresent(p -> {
            product.setId(id);
            this.repository.save(product);
        });

        return product;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.repository.findById(id).ifPresent(p -> {
            this.repository.delete(p);
        });
    }
}
