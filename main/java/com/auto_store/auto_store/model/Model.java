package com.auto_store.auto_store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "model")
public class Model extends BaseEntity {
    @Column(name = "type")
    private String type;

    @Column(name = "generation")
    private String generation;

    @Column(name = "country")
    private String country;

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Engine> engines;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Car> cars;
}
