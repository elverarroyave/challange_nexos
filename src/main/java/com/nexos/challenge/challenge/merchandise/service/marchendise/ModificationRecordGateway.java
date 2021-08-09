package com.nexos.challenge.challenge.merchandise.service.marchendise;

import com.nexos.challenge.challenge.merchandise.model.MerchandiseModificationRecord;

import javax.validation.constraints.NotNull;

public interface ModificationRecordGateway {
    MerchandiseModificationRecord save(@NotNull MerchandiseModificationRecord merchandiseModificationRecord);

    void deleteRecordinMerchandise(Long id);
}
