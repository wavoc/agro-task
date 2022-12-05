package com.example.csvtask.service;

import com.example.csvtask.dto.City;
import com.example.csvtask.entity.CityEntity;
import com.example.csvtask.repository.CitiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DBsort implements SortService {
    private final CitiesRepository repository;

    @Override
    public List<Integer> sortedIntegers() {
        return repository.getAllByIdIsNotNullOrderByCityCode().stream().map(CityEntity::getCityCode).toList();
    }

    @Override
    public List<String> sortedStrings() {
        return repository.getAllByIdIsNotNullOrderByCityName().stream().map(CityEntity::getCityName).toList();
    }

    @Override
    public List<City> sortedCitiesByCode() {
        return repository.getAllByIdIsNotNullOrderByCityCode().stream().map(CityEntity::getCity)
                .sorted(Comparator.comparing(City::getCity_code)).toList();
    }

    @Override
    public List<City> sortedCitiesByName() {
        return repository.getAllByIdIsNotNullOrderByCityName().stream().map(CityEntity::getCity)
                .sorted(Comparator.comparing(City::getCity)).toList();
    }
}
