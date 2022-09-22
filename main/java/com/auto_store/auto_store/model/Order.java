package com.auto_store.auto_store.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "new_order")
public class Order extends BaseEntity {
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_total")
    private Double orderTotal;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Car> cars;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Shipping> shippings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;
}
