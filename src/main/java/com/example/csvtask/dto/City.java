package com.example.csvtask.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @CsvBindByName
    private Integer city_code;

    @CsvBindByName
    private String city;
}
