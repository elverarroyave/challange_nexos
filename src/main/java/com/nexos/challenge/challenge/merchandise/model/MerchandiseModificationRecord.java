package com.nexos.challenge.challenge.merchandise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexos.challenge.challenge.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder(toBuilder = true)
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MerchandiseModificationRecord")
@Table(name = "MERCHANDISE_MODIFICATION_RECORD")
public class MerchandiseModificationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long merchandiseId;

    private LocalDate updateDate;
}
