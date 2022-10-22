package com.auto_store.auto_store.model;

import lombok.*;

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

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private Set<Engine> engines;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private Set<Car> cars;

    @Override
    public String toString() {
        return "Model{" +
                "type='" + type + '\'' +
                ", generation='" + generation + '\'' +
                ", country='" + country + '\'' +
                ", mark=" + mark +
                ", engines=" + engines +
                '}';
    }
}
