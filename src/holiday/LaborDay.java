package holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class LaborDay implements Holiday{

    @Override
    public boolean isHoliday(LocalDate date) {
        if(date.getMonth() == Month.SEPTEMBER && date.isEqual(date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)))){
            return true;
        }
        return false;
    }
}
