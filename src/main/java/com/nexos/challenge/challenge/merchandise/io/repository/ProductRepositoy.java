package com.nexos.challenge.challenge.merchandise.io.repository;

import com.nexos.challenge.challenge.merchandise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoy extends JpaRepository<Product, Long> {

}
