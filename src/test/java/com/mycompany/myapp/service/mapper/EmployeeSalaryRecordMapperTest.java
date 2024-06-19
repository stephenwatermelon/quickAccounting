package com.mycompany.myapp.service.mapper;

import static com.mycompany.myapp.domain.EmployeeSalaryRecordAsserts.*;
import static com.mycompany.myapp.domain.EmployeeSalaryRecordTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeSalaryRecordMapperTest {

    private EmployeeSalaryRecordMapper employeeSalaryRecordMapper;

    @BeforeEach
    void setUp() {
        employeeSalaryRecordMapper = new EmployeeSalaryRecordMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getEmployeeSalaryRecordSample1();
        var actual = employeeSalaryRecordMapper.toEntity(employeeSalaryRecordMapper.toDto(expected));
        assertEmployeeSalaryRecordAllPropertiesEquals(expected, actual);
    }
}
