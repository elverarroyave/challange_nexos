package com.nexos.challenge.challenge.merchandise.service.product;

import com.nexos.challenge.challenge.merchandise.model.Product;
import com.sun.istack.NotNull;

public interface ProductGategay {
    Product create(@NotNull Product productToCreate);

    /*
    Product update(@NotNull Product productToUpdate);

    void deleteById(@NotNull Long id);

    Product findByid(@NotNull Long id);
     */
}
