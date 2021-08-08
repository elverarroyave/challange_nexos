package com.nexos.challenge.challenge.merchandise.io.gateway;

import com.nexos.challenge.challenge.merchandise.io.repository.MerchandiseRepository;
import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.nexos.challenge.challenge.merchandise.service.marchendise.MerchandiseGategay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class MerchandiseGategayImpl implements MerchandiseGategay {

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    @Override
    public Merchandise save(Merchandise merchandiseToCreate) {
        Merchandise merchandiseToBeCreate = merchandiseToCreate.toBuilder()
                .updateDate(LocalDate.now())
                .build();
        return merchandiseRepository.save(merchandiseToBeCreate);
    }
}