package holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class IndependenceDay implements Holiday {

    @Override
    public boolean isHoliday(LocalDate date) {
        LocalDate independenceDay = LocalDate.of(date.getYear(), Month.JULY, 4);
        if(independenceDay.getDayOfWeek() == DayOfWeek.SATURDAY) {
            independenceDay = independenceDay.minusDays(1);
        } else if (independenceDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            independenceDay = independenceDay.plusDays(1);
        }

        return date.isEqual(independenceDay);
    }

}
