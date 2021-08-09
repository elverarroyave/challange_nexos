package com.nexos.challenge.challenge.merchandise.io.repository;

import com.nexos.challenge.challenge.merchandise.model.MerchandiseModificationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ModificationRecordRepository extends JpaRepository<MerchandiseModificationRecord, Long > {

    @Transactional
    @Modifying
    @Query("DELETE FROM MerchandiseModificationRecord m WHERE m.merchandiseId = ?1")
    void deleteRecordinMerchandise(Long idMerchandise);
}
