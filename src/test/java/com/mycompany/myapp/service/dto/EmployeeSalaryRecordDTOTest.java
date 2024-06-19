package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EmployeeSalaryRecordDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmployeeSalaryRecordDTO.class);
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO1 = new EmployeeSalaryRecordDTO();
        employeeSalaryRecordDTO1.setId(1L);
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO2 = new EmployeeSalaryRecordDTO();
        assertThat(employeeSalaryRecordDTO1).isNotEqualTo(employeeSalaryRecordDTO2);
        employeeSalaryRecordDTO2.setId(employeeSalaryRecordDTO1.getId());
        assertThat(employeeSalaryRecordDTO1).isEqualTo(employeeSalaryRecordDTO2);
        employeeSalaryRecordDTO2.setId(2L);
        assertThat(employeeSalaryRecordDTO1).isNotEqualTo(employeeSalaryRecordDTO2);
        employeeSalaryRecordDTO1.setId(null);
        assertThat(employeeSalaryRecordDTO1).isNotEqualTo(employeeSalaryRecordDTO2);
    }
}
