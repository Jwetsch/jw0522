package test;

import holiday.Holiday;
import holiday.IndependenceDay;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IndependenceDayTest {

    @Test
    void isHoliday_When4thIsMonday_Given5th_ExpectFalse() {
        Holiday fourth = new IndependenceDay();
        boolean isHoliday = fourth.isHoliday(LocalDate.of(2022, 7, 5));
        assertFalse(isHoliday);
    }

    @Test
    void isHoliday_When4thIsMonday_Given4th_ExpectTrue() {
        Holiday fourth = new IndependenceDay();
        boolean isHoliday = fourth.isHoliday(LocalDate.of(2022, 7, 4));
        assertTrue(isHoliday);
    }

    @Test
    void isHoliday_When4thIsSaturday_Given3rdExpectTrue() {
        Holiday fourth = new IndependenceDay();
        boolean isHoliday = fourth.isHoliday(LocalDate.of(2026, 7, 3));
        assertTrue(isHoliday);
    }

    @Test
    void isHoliday_When4thIsSunday_Given5thExpectTrue() {
        Holiday fourth = new IndependenceDay();
        boolean isHoliday = fourth.isHoliday(LocalDate.of(2027, 7, 5));
        assertTrue(isHoliday);
    }


}