package com.auto_store.auto_store.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "new_order")
public class NewOrder extends BaseEntity {
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_total")
    private Double orderTotal;

    @OneToMany(mappedBy="new_order", cascade = CascadeType.ALL)
    private Set<Car> cars;

    @OneToMany(mappedBy="new_order", cascade = CascadeType.ALL)
    private Set<Shipping> shippings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @Override
    public String toString() {
        return "NewOrder{" +
                "orderDate=" + orderDate +
                ", shippingDate=" + shippingDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTotal=" + orderTotal +
                ", shippings=" + shippings +
                ", payment=" + payment +
                '}';
    }
}
