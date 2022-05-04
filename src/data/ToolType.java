package data;

import java.math.BigDecimal;

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
}
