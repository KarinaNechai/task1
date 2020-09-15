package com.charakhovich.triangle.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {
    private static final String COORDINATE_SEPARATOR = "\\,";
    private static final String POINT_SEPARATOR = "[()]";

    public List<String> parseData(String parseString, String separator) {
        String[] arrayString = parseString.split(separator);
        List<String> resultList = Arrays.stream(arrayString)
                .map(String::trim).filter(s -> !s.isBlank()).collect(Collectors.toList());
        return resultList;
    }

}
