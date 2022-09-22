package com.auto_store.auto_store.model;

import com.auto_store.auto_store.enums.ERole;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "role")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ERole name;

    @OneToMany(mappedBy="role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> user;

    public Role(ERole nameRoles) {
        this.name = nameRoles;
    }
}