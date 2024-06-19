package com.mycompany.myapp.initData;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InsuranceRangeData extends AbstractRangeData {

    /**
     * salary including allowance
     */
    private Integer salary;

    /**
     * Employees' health insurance whose age is over and equal to 40
     */
    private Double healthInsuranceFeesOver40;

    /**
     * Health insurance for employees under 40
     */
    private Double healthInsuranceFeesUnder40;

    /**
     * Employees' pension insurance
     */
    private Double pensionInsuranceFees;

    /**
     * Labour insurance
     * total salary *6 / 1000
     */
    private Integer labourInsuranceFees;

}
