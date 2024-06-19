package com.mycompany.myapp.initData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxTable {

    private static List<TaxRangeData> taxTable;

    public static void getResourceContent() {
        String jsonFilePath = "E:/quickAccounting/src/main/resources/initData/taxData06.json";

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file and convert to Map
            taxTable = objectMapper.readValue(new File(jsonFilePath),
                new TypeReference<List<TaxRangeData>>(){});

            // Print the map (or use it as needed)
            taxTable.forEach(row -> System.out.println(row));

//            taxTable.forEach((sheetName, sheetData) -> {
//                System.out.println("Sheet: " + sheetName);
//                sheetData.forEach(row -> System.out.println(row));
//            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer getTax(Integer salary, int numberOfDependents) {
        if(salary < taxTable.get(0).getMinAmount()) {
            return 0;
        }

        if(salary > taxTable.get(taxTable.size()-1).getMinAmount()) {
            return Integer.MAX_VALUE;
        }

        for(TaxRangeData data : taxTable) {
            if(salary >= data.getMinAmount() && salary < data.getMaxAmount()) {
                return switch (numberOfDependents) {
                    case 0 -> data.getDependents0();
                    case 1 -> data.getDependents1();
                    case 2 -> data.getDependents2();
                    case 3 -> data.getDependents3();
                    case 4 -> data.getDependents4();
                    case 5 -> data.getDependents5();
                    case 6 -> data.getDependents6();
                    case 7 -> data.getDependents7();
                    default -> null;
                };
            }
        }

        return -1;
    }
}
