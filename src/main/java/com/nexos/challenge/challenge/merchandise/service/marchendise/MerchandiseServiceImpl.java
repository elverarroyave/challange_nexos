package com.nexos.challenge.challenge.merchandise.service.marchendise;

import com.nexos.challenge.challenge.config.exeption.UnauthorizedUser;
import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.nexos.challenge.challenge.merchandise.model.Product;
import com.nexos.challenge.challenge.merchandise.service.marchendise.model.MerchandiseProductDetaill;
import com.nexos.challenge.challenge.merchandise.service.marchendise.validations.ValidationMerchandise;
import com.nexos.challenge.challenge.merchandise.service.product.ProductGategay;
import com.nexos.challenge.challenge.user.service.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchandiseServiceImpl implements MerchandiseService{

    @Autowired
    private MerchandiseGategay merchandiseGategay;

    @Autowired
    private ProductGategay productGategay;

    @Autowired
    private UserGateway userGateway;

    @Autowired
    private ValidationMerchandise validationMerchandise;

    @Override
    public Merchandise save(MerchandiseProductDetaill productDetaill) {

        validationMerchandise.validations(productDetaill);

        //Creamos el producto de la mercancia
        Product productToCrate = new Product(
            productDetaill.getProductName(),
            productDetaill.getAmount()
        );

        productGategay.create(productToCrate);

        //Creamos la venta
        Merchandise merchandiseToCreate = Merchandise.builder()
                .admisionDate(productDetaill.getAdmisionDate())
                .product(productToCrate)
                .user(userGateway.findById(productDetaill.getUserId()))
                .build();

        return merchandiseGategay.save(merchandiseToCreate);

    }
}
