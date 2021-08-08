package com.nexos.challenge.challenge.merchandise.io.repository;

import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchandiseRepository extends JpaRepository<Merchandise, Long> {

}
