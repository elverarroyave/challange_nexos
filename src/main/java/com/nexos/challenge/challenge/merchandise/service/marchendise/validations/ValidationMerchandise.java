package com.nexos.challenge.challenge.merchandise.service.marchendise.validations;

import com.nexos.challenge.challenge.config.exeption.BadRequestExeption;
import com.nexos.challenge.challenge.config.exeption.UnauthorizedUser;
import com.nexos.challenge.challenge.merchandise.service.marchendise.model.MerchandiseProductDetaill;
import com.nexos.challenge.challenge.merchandise.service.product.ProductGategay;
import com.nexos.challenge.challenge.user.service.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
public class ValidationMerchandise {

    @Autowired
    private UserGateway userGateway;

    @Autowired
    private ProductGategay productGategay;

    public void validations(MerchandiseProductDetaill productDetaill){
        //Existencia de usuario
        if(!userGateway.verifyUserExits(productDetaill.getUserId()).isPresent()){
            throw new UnauthorizedUser("Usuario no registrado y sin autorizacion");
        }

        //Nombre unico de mercancia
        if(productGategay.findByName(productDetaill.getProductName().toLowerCase(Locale.ROOT).trim()).isPresent()){
            throw new BadRequestExeption("Mercancia con este nombre ya existe.");
        }

        //Validacion de fecha de ingreso
        if(productDetaill.getAdmisionDate().isAfter(LocalDate.now())){
            throw new BadRequestExeption("Fecha de ingreso de mercancia es mayor a la actual.");
        }
    }
}
