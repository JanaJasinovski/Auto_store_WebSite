package com.auto_store.auto_store.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "car")
public class Car extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    public Long count;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "new_order_id")
    private NewOrder new_order;

    private boolean active = true;

    public boolean isActive() {
        return active;
    }
}
