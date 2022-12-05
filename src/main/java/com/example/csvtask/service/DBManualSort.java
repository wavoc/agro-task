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
public class DBManualSort implements SortService {

    private final CitiesRepository repository;
    @Override
    public List<Integer> sortedIntegers() {
        return repository.findAll().stream().map(CityEntity::getCityCode).sorted().toList();
    }

    @Override
    public List<String> sortedStrings() {
        return repository.findAll().stream().map(CityEntity::getCityName).sorted().toList();
    }

    @Override
    public List<City> sortedCitiesByCode() {
        return repository.findAll().stream().map(CityEntity::getCity).sorted(Comparator.comparing(City::getCity_code)).toList();
    }

    @Override
    public List<City> sortedCitiesByName() {
        return repository.findAll().stream().map(CityEntity::getCity).sorted(Comparator.comparing(City::getCity)).toList();
    }
}
