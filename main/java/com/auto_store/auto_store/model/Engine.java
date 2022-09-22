package com.auto_store.auto_store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "engine")
public class Engine extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "volume")
    private int volume;

    @Column(name = "power")
    private int power;

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;
}
