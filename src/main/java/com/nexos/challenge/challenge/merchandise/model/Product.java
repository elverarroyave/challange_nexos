package com.nexos.challenge.challenge.merchandise.model;

import lombok.*;

import javax.persistence.*;

@Data
@Generated
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCT")
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    public Product(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

}
