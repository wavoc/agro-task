package com.example.csvtask.service;

import com.example.csvtask.dto.City;

import java.io.FileNotFoundException;
import java.util.List;

public interface SortService {

    List<Integer> sortedIntegers() throws FileNotFoundException;

    List<String> sortedStrings() throws FileNotFoundException;

    List<City> sortedCitiesByCode();

    List<City> sortedCitiesByName();
}
