package com.offer.management.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BrandRequest {
    @JsonProperty("name")
    private String name;

}
