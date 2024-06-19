package com.mycompany.myapp.initData;

import java.util.List;
import lombok.Data;

@Data
public class RangeData {

    private List<AbstractRangeData> rangeDataList;

    public AbstractRangeData getRangeData(Integer salary) {
        for (AbstractRangeData data : rangeDataList) {
            // TODO maybe need to be change method
            if (salary >= data.getMinAmount() && salary < data.getMaxAmount()) {
                return data;
            }
        }

        return rangeDataList.get(rangeDataList.size() - 1);
    }

    public void setRangeData(AbstractRangeData rangeData) {
        //AbstractRangeData data = new rangeData.getClass();

    }
}
