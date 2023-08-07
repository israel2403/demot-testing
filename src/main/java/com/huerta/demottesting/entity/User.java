package com.huerta.demottesting.entity;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class User {
    private UUID id;
    private String name;
    private String lastName;
    private BigDecimal salary;
    private Integer year;
}
