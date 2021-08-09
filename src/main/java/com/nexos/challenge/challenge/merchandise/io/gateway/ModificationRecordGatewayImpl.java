package com.nexos.challenge.challenge.merchandise.io.gateway;

import com.nexos.challenge.challenge.merchandise.io.repository.ModificationRecordRepository;
import com.nexos.challenge.challenge.merchandise.model.MerchandiseModificationRecord;
import com.nexos.challenge.challenge.merchandise.service.marchendise.ModificationRecordGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class ModificationRecordGatewayImpl implements ModificationRecordGateway {

    @Autowired
    ModificationRecordRepository modificationRecordRepository;

    @Override
    public MerchandiseModificationRecord save(MerchandiseModificationRecord merchandiseModificationRecord) {
        merchandiseModificationRecord.setUpdateDate(LocalDate.now());
        return modificationRecordRepository.save(merchandiseModificationRecord);
    }

    @Override
    public void deleteRecordinMerchandise(Long id) {
        modificationRecordRepository.deleteRecordinMerchandise(id);
    }
}
