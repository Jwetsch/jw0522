package data;

import java.math.BigDecimal;
import java.util.Objects;

public class ToolType {

    private String toolType;
    private BigDecimal dailyCharge;
    private boolean weekDayCharge = true;
    private boolean weekEndCharge = true;
    private boolean holidayCharge = true;

    public String getToolType() {
        return toolType;
    }

    public ToolType setToolType(String toolType) {
        this.toolType = toolType;
        return this;
    }

    public BigDecimal getDailyCharge() {
        return dailyCharge;
    }

    public ToolType setDailyCharge(BigDecimal dailyCharge) {
        this.dailyCharge = dailyCharge;
        return this;
    }

    public boolean isWeekDayCharge() {
        return weekDayCharge;
    }

    public ToolType setWeekDayCharge(boolean weekDayCharge) {
        this.weekDayCharge = weekDayCharge;
        return this;
    }

    public boolean isWeekEndCharge() {
        return weekEndCharge;
    }

    public ToolType setWeekEndCharge(boolean weekEndCharge) {
        this.weekEndCharge = weekEndCharge;
        return this;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }

    public ToolType setHolidayCharge(boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToolType toolType1 = (ToolType) o;
        return toolType.equals(toolType1.toolType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toolType);
    }
}
