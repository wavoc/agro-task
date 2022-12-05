package com.example.csvtask.repository;

import com.example.csvtask.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepository extends JpaRepository<CityEntity, Long> {
    void deleteAllByIdIsNotNull();

    List<CityEntity> getAllByIdIsNotNullOrderByCityCode();

    List<CityEntity> getAllByIdIsNotNullOrderByCityName();
}
