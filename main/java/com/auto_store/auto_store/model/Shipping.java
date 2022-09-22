package com.auto_store.auto_store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "shipping")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shipping extends BaseEntity{

    @Column(name = "receiver")
    private String receiver;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;
}
