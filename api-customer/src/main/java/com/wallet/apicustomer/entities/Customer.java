package com.wallet.apicustomer.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long id;
    private String documentType;
    private int documentNumber;
    private String name;
    private String lastName;
    private String genre;
    private LocalDate birthDate;


}
