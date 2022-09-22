package com.auto_store.auto_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "car")
public class Car extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    public int count;

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;

    @ManyToOne
    private Order order;
}
