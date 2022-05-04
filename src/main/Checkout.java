package main;

import data.*;
import data.Error;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private static List<String> errorAccumulator = new ArrayList<>();


    public static void execute(Request r) {
        DataStore.initialize();
        Response response = checkOut(r);
        response.displayResponse();
    }

    public static Response checkOut(Request r){

        validate(r);
        if(!errorAccumulator.isEmpty()) {
            return new Error(String.join("\n", errorAccumulator));
        }

        Tool tool = DataStore.findTool(r.getToolCode());
        ToolType toolType = DataStore.findToolType(tool.getToolType());

        return new RentalAgreement()
                .setToolCode(r.getToolCode())
                .setToolType(tool.getToolType())
                .setToolBrand(tool.getBrand())
                .setRentalDays(r.getDayCount())
                .setCheckOut(r.getCheckOut())
                .setDueDate(LocalDate.now())
                .setDailyCharge(toolType.getDailyCharge())
                .setChargeDays(2)
                .setPreDiscountCharge(new BigDecimal("4"))
                .setDiscount(20)
                .setDiscountAmount(new BigDecimal(".5"))
                .setFinalCharge(new BigDecimal("3.5"));
    }

    private static void validate(Request r) {
        if(r.getDayCount()<1){
            errorAccumulator.add("You must rent the tool for a minimum of one day");
        }
        if (r.getDiscount() < 0 || r.getDiscount() > 100) {
            errorAccumulator.add("Discount must be between 0% and 100%");
        }
    }


    public interface Request {

        String getToolCode();

        Integer getDayCount();

        Integer getDiscount();

        LocalDate getCheckOut();

    }


}
