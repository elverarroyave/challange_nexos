package com.nexos.challenge.challenge.merchandise.service.marchendise;

import com.nexos.challenge.challenge.config.exeption.BadRequestExeption;
import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.nexos.challenge.challenge.merchandise.model.MerchandiseModificationRecord;
import com.nexos.challenge.challenge.merchandise.model.Product;
import com.nexos.challenge.challenge.merchandise.service.marchendise.model.MerchandiseProductDetail;
import com.nexos.challenge.challenge.merchandise.service.marchendise.validations.ValidationMerchandise;
import com.nexos.challenge.challenge.merchandise.service.product.ProductGateway;
import com.nexos.challenge.challenge.user.service.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class MerchandiseServiceImpl implements MerchandiseService{

    @Autowired
    private MerchandiseGateway merchandiseGateway;

    @Autowired
    private ProductGateway productGateway;

    @Autowired
    private UserGateway userGateway;

    @Autowired
    private ValidationMerchandise validationMerchandise;

    @Autowired
    private ModificationRecordGateway modificationRecordGateway;

    @Override
    public Merchandise save(MerchandiseProductDetail productDetail) {

        validationMerchandise.validations(productDetail);

        //Creamos el producto de la mercancia
        Product productToCrate = new Product(
            productDetail.getProductName(),
            productDetail.getAmount()
        );

        productGateway.create(productToCrate);

        //Creamos la venta
        Merchandise merchandiseToCreate = Merchandise.builder()
                .admisionDate(productDetail.getAdmisionDate())
                .product(productToCrate)
                .user(userGateway.findById(productDetail.getUserId()))
                .build();

        return merchandiseGateway.save(merchandiseToCreate);

    }

    @Override
    public Merchandise update(@NotNull Long id, @NotNull MerchandiseProductDetail productDetail) {

        validationMerchandise.validations(productDetail);

        Merchandise merchandiseInDataBase = merchandiseGateway.findById(id);

        Product productToUpdate = merchandiseInDataBase.getProduct();

        productToUpdate.setName(productDetail.getProductName());
        productToUpdate.setAmount(productDetail.getAmount());

        productGateway.create(productToUpdate);

        Merchandise merchandiseToUpdate = merchandiseInDataBase.toBuilder()
                .admisionDate(productDetail.getAdmisionDate())
                .product(productToUpdate)
                .user(userGateway.findById(productDetail.getUserId()))
                .build();

        Merchandise merchandiseUpdated = merchandiseGateway.update(merchandiseToUpdate);

        MerchandiseModificationRecord merchandiseModificationRecord = MerchandiseModificationRecord.builder()
                .merchandiseId(id)
                .userId(merchandiseUpdated.getUser().getId())
                .build();

        modificationRecordGateway.save(merchandiseModificationRecord);

        return merchandiseToUpdate;
    }

    @Override
    public void delete(Long id, Long userId) {

        Merchandise merchandise = merchandiseGateway.findById(id);

        //Validacion usuario para eliminar mercnacia
        if(userId != merchandise.getUser().getId()){
            throw new BadRequestExeption("Usuario no autorizado para eliminar pedido");
        }

        modificationRecordGateway.deleteRecordinMerchandise(id);

        merchandiseGateway.deleteById(id);
    }


}
