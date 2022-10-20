package com.auto_store.auto_store.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Arrays;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDTO {

    private Integer id;
    private String name;
    private Double price;
    private byte[] image;
    private String model_Type;
    private String model_Generation;
    private String model_Country;
    private Date new_order_orderDate;
    private Date new_order_shipping_date;
    private String new_order_status;
    private Double new_order_total;
    private Long count;

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image=" + Arrays.toString(image) +
                ", model_Type='" + model_Type + '\'' +
                ", model_Generation='" + model_Generation + '\'' +
                ", model_Country='" + model_Country + '\'' +
                ", new_order_orderDate=" + new_order_orderDate +
                ", new_order_shipping_date=" + new_order_shipping_date +
                ", new_order_status='" + new_order_status + '\'' +
                ", new_order_total=" + new_order_total +
                ", count=" + count +
                '}';
    }
}
