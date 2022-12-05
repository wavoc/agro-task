package com.example.csvtask;

import com.example.csvtask.service.SortService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;


@SpringBootTest
class CsvTaskApplicationTests {
    @Autowired
    SortService service;

    @Value("${file.name}")
    private String FILE_NAME;


    @Test
    void contextLoads() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_NAME).getFile());
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.canRead());
    }

    @Test
    void printSortedIntegers() throws FileNotFoundException {
        var list = service.sortedIntegers();
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(50000, list.size());
        print(list);
    }


    @Test
    void printSortedString() throws FileNotFoundException {
        var list = service.sortedStrings();
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(50000, list.size());
        print(list);
    }

    @Test
    void printCitiesSortedByCode() throws FileNotFoundException {
        var list = service.sortedCitiesByCode();
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(50000, list.size());
        print(list);
    }

    @Test
    void printCitiesSortedByName() throws FileNotFoundException {
        var list = service.sortedCitiesByName();
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(50000, list.size());
        print(list);
    }

    private void print(List list){
        for (var i : list) {
            System.out.println(i.toString());
        }
    }

}
