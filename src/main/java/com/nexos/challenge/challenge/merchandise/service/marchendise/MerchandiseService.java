package com.nexos.challenge.challenge.merchandise.service.marchendise;

import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.nexos.challenge.challenge.merchandise.service.marchendise.model.MerchandiseProductDetaill;

public interface MerchandiseService {
    Merchandise save(MerchandiseProductDetaill merchandiseToCreateCmd);
}
