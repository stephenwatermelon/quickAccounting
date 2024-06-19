package com.mycompany.myapp.initData;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class InsuranceDTO {

    /**
     * Health insurance for employees
     */
    private Integer healthInsuranceFees;

    /**
     * Employees' pension insurance
     */
    private Integer pensionInsuranceFees;

    public Integer getTotalInsurance()
    {
        return healthInsuranceFees + pensionInsuranceFees;

    }

}
