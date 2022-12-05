package com.example.csvtask.entity;

import com.example.csvtask.dto.City;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cities")
@NoArgsConstructor
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cityCode;

    private String cityName;

    public CityEntity(Integer cityCode, String cityName) {
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    @Transient
    public City getCity() {
        return new City(cityCode, cityName);
    }
}
