package com.nexos.challenge.challenge.merchandise.service.marchendise.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MerchandiseProductDetaill {

    private int amount;

    private LocalDate admisionDate;

    private Long userId;

    private String productName;
}
