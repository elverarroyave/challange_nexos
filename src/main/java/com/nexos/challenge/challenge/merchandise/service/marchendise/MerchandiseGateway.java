package com.nexos.challenge.challenge.merchandise.service.marchendise;

import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.sun.istack.NotNull;

public interface MerchandiseGateway {

    Merchandise save(@NotNull  Merchandise merchandiseToCreate);
}
