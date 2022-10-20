package com.auto_store.auto_store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "new_order")
public class New_Order extends BaseEntity {
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_total")
    private Double orderTotal;

    @OneToMany(mappedBy="new_order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Car> cars;

    @OneToMany(mappedBy="new_order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Shipping> shippings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;
}
