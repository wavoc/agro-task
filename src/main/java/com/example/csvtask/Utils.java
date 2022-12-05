package com.example.csvtask;

import com.example.csvtask.entity.CityEntity;
import com.example.csvtask.repository.CitiesRepository;
import com.example.csvtask.service.SortService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Utils {
    private final CitiesRepository repository;
    private final SortService sortService;

    @PostConstruct
    void init() throws FileNotFoundException {
        repository.deleteAllByIdIsNotNull();
        var list = sortService.sortedCitiesByCode();
        List<CityEntity> entities = list.stream().map(e -> new CityEntity(e.getCity_code(), e.getCity())).toList();
        repository.saveAll(entities);
    }
}
