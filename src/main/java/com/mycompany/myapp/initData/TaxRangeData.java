package com.mycompany.myapp.initData;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaxRangeData extends AbstractRangeData {

    /**
     * salary including allowance but except Commuting allowance minus Insurance fees
     */
    private Integer salary;

    /**
     * Number of dependents
     */
    private Integer numberOfDependents;

    /**
     * tax
     */
    private Integer taxAmount;

    private Integer dependents0;
    private Integer dependents1;
    private Integer dependents2;
    private Integer dependents3;
    private Integer dependents4;
    private Integer dependents5;
    private Integer dependents6;
    private Integer dependents7;
}
