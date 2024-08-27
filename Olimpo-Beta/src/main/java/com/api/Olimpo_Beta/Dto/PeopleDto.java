package com.api.Olimpo_Beta.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDto {
    private Long documentNumber;
    private String name;
    private String lastname;
    private String documentType;
}
