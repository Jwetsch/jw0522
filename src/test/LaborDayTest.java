package test;

import holiday.Holiday;
import holiday.LaborDay;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class LaborDayTest {

    @Test
    void isHoliday_given09052022_expectTrue() {
        Holiday laborDay = new LaborDay();
        boolean isHoliday = laborDay.isHoliday(LocalDate.of(2022, Month.SEPTEMBER, 5));
        assertTrue(isHoliday);
    }

    @Test
    void isHoliday_given09062022_expectFalse() {
        Holiday laborDay = new LaborDay();
        boolean isHoliday = laborDay.isHoliday(LocalDate.of(2022, Month.SEPTEMBER, 6));
        assertFalse(isHoliday);
    }
}