package com.nexos.challenge.challenge.merchandise.service.marchendise;

import com.nexos.challenge.challenge.merchandise.model.Merchandise;

import javax.validation.constraints.NotNull;

public interface MerchandiseGateway {

    Merchandise save(@NotNull Merchandise merchandiseToCreate);

    Merchandise update(@NotNull Merchandise merchandiseToUpdate);

    Merchandise findById(@NotNull Long id);

    void deleteById(@NotNull Long id);


}
