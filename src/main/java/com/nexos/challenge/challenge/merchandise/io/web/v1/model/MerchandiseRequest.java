package com.nexos.challenge.challenge.merchandise.io.web.v1.model;

import com.nexos.challenge.challenge.merchandise.service.marchendise.model.MerchandiseProductDetaill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchandiseRequest {

    private int amount;

    private String admisionDate;

    private Long userId;

    private String productName;

    public static MerchandiseProductDetaill toModelCmd(MerchandiseRequest merchandiseRequest){
        return MerchandiseProductDetaill.builder()
                .amount(merchandiseRequest.getAmount())
                .admisionDate(formatDate(merchandiseRequest.getAdmisionDate()))
                .userId(merchandiseRequest.getUserId())
                .productName(merchandiseRequest.getProductName().toLowerCase(Locale.ROOT).trim())
                .build();
    }

    private static LocalDate formatDate(String stringDate){
        String[] date = stringDate.split("-");

        LocalDate localDate = LocalDate.of(
                Integer.parseInt(date[0]),
                Integer.parseInt(date[1]),
                Integer.parseInt(date[2])
        );
        return localDate;
    }
}
