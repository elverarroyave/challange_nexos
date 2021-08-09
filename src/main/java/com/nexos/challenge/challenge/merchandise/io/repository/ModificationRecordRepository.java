package com.nexos.challenge.challenge.merchandise.io.repository;

import com.nexos.challenge.challenge.merchandise.model.MerchandiseModificationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModificationRecordRepository extends JpaRepository<MerchandiseModificationRecord, Long > {
}
