package com.nexos.challenge.challenge.merchandise.io.gateway;

import com.nexos.challenge.challenge.merchandise.io.repository.ProductRepositoy;
import com.nexos.challenge.challenge.merchandise.model.Product;
import com.nexos.challenge.challenge.merchandise.service.product.ProductGategay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductGategayImpl implements ProductGategay {

    @Autowired
    private ProductRepositoy productRepositoy;

    @Override
    public Product create(Product productToCreate) {
        return productRepositoy.save(productToCreate);
    }
}
