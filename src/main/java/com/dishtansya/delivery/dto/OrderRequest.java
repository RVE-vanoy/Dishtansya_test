package com.dishtansya.delivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    @JsonProperty("product_id")
    private Integer productId;

    private Integer quantity;
}