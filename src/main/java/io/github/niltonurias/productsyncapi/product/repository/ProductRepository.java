package io.github.niltonurias.productsyncapi.product.repository;

import io.github.niltonurias.productsyncapi.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
