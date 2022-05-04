package main;

import data.*;
import data.Error;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static data.DataStore.getHolidays;

public class Checkout {

    public static Response checkOut(Request r){
        List<String> errorAccumulator = new ArrayList<>();
        validate(r, errorAccumulator);
        if(!errorAccumulator.isEmpty()) {
            return new Error(String.join("\n", errorAccumulator));
        }

        Tool tool = DataStore.findTool(r.getToolCode());
        ToolType toolType = DataStore.findToolType(tool.getToolType());

        Integer freeDays = calculateFreeDays(toolType, getDateList(r));

        Integer chargeDays = r.getDayCount() - freeDays;

        BigDecimal preDiscountCharge = calculatePreDiscountCharge(toolType, chargeDays);

        BigDecimal discountAmount = calculateDiscountAmount(preDiscountCharge, r.getDiscount());

        BigDecimal finalCharge = preDiscountCharge.subtract(discountAmount);

        return new RentalAgreement()
                .setToolCode(r.getToolCode())
                .setToolType(tool.getToolType())
                .setToolBrand(tool.getBrand())
                .setRentalDays(r.getDayCount())
                .setCheckOut(r.getCheckOut())
                .setDueDate(r.getCheckOut().plusDays(r.getDayCount()))
                .setDailyCharge(toolType.getDailyCharge())
                .setChargeDays(chargeDays)
                .setPreDiscountCharge(preDiscountCharge)
                .setDiscount(r.getDiscount())
                .setDiscountAmount(discountAmount)
                .setFinalCharge(finalCharge);
    }

    private static void validate(Request r, List<String> errorAccumulator) {
        if(r.getDayCount()<1){
            errorAccumulator.add("You must rent the tool for a minimum of one day");
        }
        if (r.getDiscount() < 0 || r.getDiscount() > 100) {
            errorAccumulator.add("Discount must be between 0% and 100%");
        }
    }

    private static List<LocalDate> getDateList(Request r) {
        return r.getCheckOut().plusDays(1).datesUntil(r.getCheckOut().plusDays(r.getDayCount()+1)).collect(Collectors.toList());
    }

    private static Integer calculateFreeDays(ToolType toolType, List<LocalDate> dateList) {
        AtomicInteger freeDays = new AtomicInteger();
        if(!toolType.isWeekDayCharge())
            dateList.stream().filter(Checkout::calculateWeekdayFreeDay).forEach(w-> freeDays.getAndIncrement());
        if(!toolType.isWeekEndCharge())
            dateList.stream().filter(Checkout::calculateWeekendFreeDay).forEach(w ->freeDays.getAndIncrement());
        if(!toolType.isHolidayCharge())
            dateList.stream().filter(Checkout::calculateHolidayFreeDay).forEach(w ->freeDays.getAndIncrement());
        return freeDays.get();
    }

    private static boolean calculateWeekdayFreeDay(LocalDate date){
        return (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY);
    }

    private static boolean calculateWeekendFreeDay(LocalDate date){
        return (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    private static boolean calculateHolidayFreeDay(LocalDate date){
        return getHolidays().stream().anyMatch(holiday -> holiday.isHoliday(date));
    }

    private static BigDecimal calculatePreDiscountCharge(ToolType toolType, Integer chargeDays) {
        return toolType.getDailyCharge().multiply(BigDecimal.valueOf(chargeDays)).setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal calculateDiscountAmount(BigDecimal preDiscount, Integer discount){
        BigDecimal percentage = BigDecimal.valueOf(discount).divide(BigDecimal.valueOf(100));
        return preDiscount.multiply(percentage).setScale(2, RoundingMode.HALF_UP);
    }


    public interface Request {

        String getToolCode();

        Integer getDayCount();

        Integer getDiscount();

        LocalDate getCheckOut();

    }


}
