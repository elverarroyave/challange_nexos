package com.nexos.challenge.challenge.merchandise.model;

import com.nexos.challenge.challenge.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Generated
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MERCHANDISE")
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MER_ID")
    private Long id;

    @Column(name = "ADMISION_DATE", nullable = false)
    private LocalDate admisionDate;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
