package com.mahmood.firstrestapi.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){

        // dynamically filter someBean
        MappingJacksonValue mapping = new MappingJacksonValue(
                new SomeBean("v1", "v2", "v3")
        );
        // allow only field1
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1");
        // the filter id should be the same as JsonFilter in the class
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("someFilter",filter);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(
                new SomeBean("v1", "v2", "v3"),
                new SomeBean("v1", "v2", "v3"),
                new SomeBean("v1", "v2", "v3")
        );
    }
}
