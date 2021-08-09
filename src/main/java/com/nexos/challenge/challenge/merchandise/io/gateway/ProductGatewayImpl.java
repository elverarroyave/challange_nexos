package com.nexos.challenge.challenge.merchandise.io.gateway;

import com.nexos.challenge.challenge.merchandise.io.repository.ProductRepository;
import com.nexos.challenge.challenge.merchandise.model.Product;
import com.nexos.challenge.challenge.merchandise.service.product.ProductGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductGatewayImpl implements ProductGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product productToCreate) {
        return productRepository.save(productToCreate);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
