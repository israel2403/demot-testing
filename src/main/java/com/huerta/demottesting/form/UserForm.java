package com.huerta.demottesting.form;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "The field lastName cannot be empty")
    private String lastName;
    @NotNull(message = "The field salary cannot be null")
    private BigDecimal salary;
    @NotNull(message = "The field age cannot be null")
    private Integer age;
    @Email(message = "This email is incorrect")
    private String email;
}
