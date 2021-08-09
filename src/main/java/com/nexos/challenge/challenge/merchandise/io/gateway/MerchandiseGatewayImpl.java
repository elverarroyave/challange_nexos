package com.nexos.challenge.challenge.merchandise.io.gateway;

import com.nexos.challenge.challenge.config.exeption.NotFoundExeption;
import com.nexos.challenge.challenge.merchandise.io.repository.MerchandiseRepository;
import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.nexos.challenge.challenge.merchandise.service.marchendise.MerchandiseGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class MerchandiseGatewayImpl implements MerchandiseGateway {

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    @Override
    public Merchandise save(Merchandise merchandiseToCreate) {
        Merchandise merchandiseToBeCreate = merchandiseToCreate.toBuilder()
                .updateDate(LocalDate.now())
                .build();
        return merchandiseRepository.save(merchandiseToBeCreate);
    }

    @Override
    public Merchandise update(Merchandise merchandiseToUpdate) {
        Merchandise merchandiseToBeCreate = merchandiseToUpdate.toBuilder()
                .updateDate(LocalDate.now())
                .build();
        return merchandiseRepository.save(merchandiseToBeCreate);
    }

    @Override
    public Merchandise findById(Long id) {
        Merchandise merchandiseFound = merchandiseRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Mercancia con id: " + id  + "no encontrada en la base de datos."));
        return merchandiseFound;
    }
}
