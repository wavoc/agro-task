package com.example.csvtask.service;

import com.example.csvtask.dto.City;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CSVManualParse implements SortService {
    @Value("${file.name}")
    private String FILE_NAME;

    private List<String> lines;

    @PostConstruct
    void init() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource(FILE_NAME).getFile()));
        var s = br.lines().collect(Collectors.toList());
        lines = s.subList(1, s.size());
    }

    @Override
    public List<Integer> sortedIntegers() {
        return lines.stream().map(e -> Integer.parseInt(e.split(",")[0])).sorted().toList();
    }

    @Override
    public List<String> sortedStrings() {
        return lines.stream().map(e -> e.split(",")[1]).sorted().toList();
    }

    @Override
    public List<City> sortedCitiesByCode() {
        return lines.stream().map(e ->
                new City(Integer.parseInt(e.split(",")[0]), e.split(",")[1])
        ).sorted(Comparator.comparing(City::getCity_code)).toList();

    }

    @Override
    public List<City> sortedCitiesByName() {
        return lines.stream().map(e ->
                new City(Integer.parseInt(e.split(",")[0]), e.split(",")[1])
        ).sorted(Comparator.comparing(City::getCity)).toList();
    }
}
