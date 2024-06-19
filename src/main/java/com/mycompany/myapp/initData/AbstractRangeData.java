package com.mycompany.myapp.initData;

import lombok.Data;

/**
 * Abstract class of range data
 */
@Data
public class AbstractRangeData {

    /**
     * Insurance/ Tax's level
     */
    private String level;

    /**
     * this range's minimum amount of salary
     */
    private Integer minAmount;

    /**
     * this range's maximum amount of salary
     */
    private Integer maxAmount;
}
