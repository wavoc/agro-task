package com.example.csvtask;

import com.example.csvtask.service.SortService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
class CSVManualParseTests {
    @Autowired
    @Qualifier("CSVManualParse")
    SortService service;

    @Test
    void printSortedIntegers() throws FileNotFoundException {
        var list = service.sortedIntegers();
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
        print(list);
    }


    @Test
    void printSortedString() throws FileNotFoundException {
        var list = service.sortedStrings();
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
        print(list);
    }

    @Test
    void printCitiesSortedByCode() {
        var list = service.sortedCitiesByCode();
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
        print(list);
    }

    @Test
    void printCitiesSortedByName() {
        var list = service.sortedCitiesByName();
        Assertions.assertNotNull(list);
        Assertions.assertFalse(list.isEmpty());
        print(list);
    }

    private void print(List list) {
        for (var i : list) {
            System.out.println(i.toString());
        }
    }
}
