package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.EmployeeSalaryRecordTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EmployeeSalaryRecordTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmployeeSalaryRecord.class);
        EmployeeSalaryRecord employeeSalaryRecord1 = getEmployeeSalaryRecordSample1();
        EmployeeSalaryRecord employeeSalaryRecord2 = new EmployeeSalaryRecord();
        assertThat(employeeSalaryRecord1).isNotEqualTo(employeeSalaryRecord2);

        employeeSalaryRecord2.setId(employeeSalaryRecord1.getId());
        assertThat(employeeSalaryRecord1).isEqualTo(employeeSalaryRecord2);

        employeeSalaryRecord2 = getEmployeeSalaryRecordSample2();
        assertThat(employeeSalaryRecord1).isNotEqualTo(employeeSalaryRecord2);
    }
}
