package com.example.csvtask.service;

import com.example.csvtask.dto.City;
import com.example.csvtask.dto.CityCode;
import com.example.csvtask.dto.CityName;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;

@Primary
@Service
public class CSVSort implements SortService{
    @Value("${file.name}")
    private String FILE_NAME;

    @Override
    public List<Integer> sortedIntegers() throws FileNotFoundException {
        List<CityCode> cityCodes = new CsvToBeanBuilder(new FileReader(getFile()))
                .withOrderedResults(false)
                .withType(CityCode.class)
                .build().parse();
        return cityCodes.parallelStream().map(CityCode::getCity_code).sorted().toList();
    }

    @Override
    public List<String> sortedStrings() throws FileNotFoundException {
        List<CityName> cityNames = new CsvToBeanBuilder(new FileReader(getFile()))
                .withOrderedResults(false)
                .withType(CityName.class)
                .build().parse();
        return cityNames.parallelStream().map(CityName::getCity).sorted().toList();
    }

    @Override
    public List<City> sortedCitiesByCode() {
        return readFromFile().stream().sorted(Comparator.comparing(City::getCity_code)).toList();
    }

    @Override
    public List<City> sortedCitiesByName() {
        return readFromFile().stream().sorted(Comparator.comparing(City::getCity)).toList();
    }

    private List<City> readFromFile(){
        try {
            return new CsvToBeanBuilder(new FileReader(getFile()))
                    .withOrderedResults(false)
                    .withType(City.class)
                    .build().parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private File getFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(FILE_NAME).getFile());
    }
}
