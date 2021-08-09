package com.nexos.challenge.challenge.merchandise.service.marchendise;

import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.nexos.challenge.challenge.merchandise.service.marchendise.model.MerchandiseProductDetail;

import javax.validation.constraints.NotNull;

public interface MerchandiseService {
    Merchandise save(MerchandiseProductDetail merchandiseToCreateCmd);

    Merchandise update(@NotNull Long id, @NotNull MerchandiseProductDetail merchandiseProductDetail);

    void delete(@NotNull Long id, Long userId);
}
