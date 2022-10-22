package com.auto_store.auto_store.dto;

import com.auto_store.auto_store.model.Model;
import com.auto_store.auto_store.model.NewOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Set;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDTO {

    private Integer id;
    private String name;
    private Double price;
    private byte[] image;
    private Long count;
    private boolean active;
    private Set<Model> models;
    private Set<NewOrder> newOrders;

}
