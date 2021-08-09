package com.nexos.challenge.challenge.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.nexos.challenge.challenge.role.model.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder(toBuilder = true)
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "ENTRY_DATE_TO_COMPANY")
    private LocalDate entryDateToCompany;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> rolesOfUser = new HashSet<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user"
    )
    @JsonIgnore
    private List<Merchandise> merchandises;

    public User(String name, int age, LocalDate entryDateToCompany) {
        this.name = name;
        this.age = age;
        this.entryDateToCompany = entryDateToCompany;
    }

    public void addRole(Role roleToAdd){
        this.rolesOfUser.add(roleToAdd);
    }
}
