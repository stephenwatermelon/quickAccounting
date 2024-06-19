package com.mycompany.myapp.initData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Period;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class InsuranceTable {

    private static Map<String, List<InsuranceRangeData>> insuranceTable06;

    private static Map<String, List<InsuranceRangeData>> insuranceTable05;

    public static void getResourceContent() {
        load06();
        load05();
    }

    private static void load06() {
        try {
            String jsonFilePath = "E:/quickAccounting/src/main/resources/initData/insuranceData06.json";

            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file and convert to Map
            insuranceTable06 = objectMapper.readValue(new File(jsonFilePath),
                new TypeReference<Map<String, List<InsuranceRangeData>>>(){});

            // Print the map (or use it as needed)
            insuranceTable06.forEach((sheetName, sheetData) -> {
                System.out.println("Sheet: " + sheetName);
                sheetData.forEach(row -> System.out.println(row));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void load05() {
        try {
            String jsonFilePath = "E:/quickAccounting/src/main/resources/initData/insuranceData05.json";

            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file and convert to Map
            insuranceTable05 = objectMapper.readValue(new File(jsonFilePath),
                new TypeReference<Map<String, List<InsuranceRangeData>>>(){});

            // Print the map (or use it as needed)
            insuranceTable05.forEach((sheetName, sheetData) -> {
                System.out.println("Sheet: " + sheetName);
                sheetData.forEach(row -> System.out.println(row));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static InsuranceDTO getInsuranceData(String year, String area, LocalDate birthDate, int totalSalary) {
        List<InsuranceRangeData> areaRangeData;
        if("06".equals(year)) {
            areaRangeData = insuranceTable06.get(area);

        } else {
            areaRangeData = insuranceTable05.get(area);
        }

        InsuranceDTO insuranceDTO = new InsuranceDTO();
        for(InsuranceRangeData data: areaRangeData)
        {
            if (data.getMinAmount() == null) {
                data.setMinAmount(0);
            }

            if (data.getMaxAmount() == null) {
                data.setMaxAmount(Integer.MAX_VALUE);
            }

            if (totalSalary >= data.getMinAmount() && totalSalary < data.getMaxAmount()) {
                if (data.getPensionInsuranceFees() == null) {
                    data.setPensionInsuranceFees(areaRangeData.get(3).getPensionInsuranceFees());
                }
                int age = calculateAge(birthDate, LocalDate.now());
                if(age < 40) {
                    insuranceDTO.setHealthInsuranceFees((int)Math.round(data.getHealthInsuranceFeesUnder40()));
                } else {
                    insuranceDTO.setHealthInsuranceFees((int)Math.round(data.getHealthInsuranceFeesOver40()));
                }
                insuranceDTO.setPensionInsuranceFees((int)Math.round(data.getPensionInsuranceFees()));
                break;
            }
        }

        return insuranceDTO;
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0; // 如果生日或当前日期为空，返回0
        }
    }

}
