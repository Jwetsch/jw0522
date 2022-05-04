package data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement extends Response{

    private String toolCode;
    private String toolType;
    private String toolBrand;
    private Integer rentalDays;
    private LocalDate checkOut;
    private LocalDate dueDate;
    private BigDecimal dailyCharge;
    private Integer chargeDays;
    private BigDecimal preDiscountCharge;
    private Integer discount;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public String getToolCode() {
        return toolCode;
    }

    public RentalAgreement setToolCode(String toolCode) {
        this.toolCode = toolCode;
        return this;
    }

    public String getToolType() {
        return toolType;
    }

    public RentalAgreement setToolType(String toolType) {
        this.toolType = toolType;
        return this;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public RentalAgreement setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
        return this;
    }

    public Integer getRentalDays() {
        return rentalDays;
    }

    public RentalAgreement setRentalDays(Integer rentalDays) {
        this.rentalDays = rentalDays;
        return this;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public RentalAgreement setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public RentalAgreement setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public BigDecimal getDailyCharge() {
        return dailyCharge;
    }

    public RentalAgreement setDailyCharge(BigDecimal dailyCharge) {
        this.dailyCharge = dailyCharge;
        return this;
    }

    public Integer getChargeDays() {
        return chargeDays;
    }

    public RentalAgreement setChargeDays(Integer chargeDays) {
        this.chargeDays = chargeDays;
        return this;
    }

    public BigDecimal getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public RentalAgreement setPreDiscountCharge(BigDecimal preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
        return this;
    }

    public Integer getDiscount() {
        return discount;
    }

    public RentalAgreement setDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public RentalAgreement setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public BigDecimal getFinalCharge() {
        return finalCharge;
    }

    public RentalAgreement setFinalCharge(BigDecimal finalCharge) {
        this.finalCharge = finalCharge;
        return this;
    }

    public void displayResponse(){
        System.out.println(
                String.format("Rental Agreement %n" +
                        "Tool Code: %s%n" +
                        "Tool Type: %s%n" +
                        "Tool Brand: %s%n" +
                        "Rental Days: %d%n" +
                        "Check Out Date: %s%n" +
                        "Due Date: %s%n" +
                        "Daily Rental Charge: $%s%n" +
                        "Charge Days: %d%n" +
                        "Pre-Discount Charge: $%s%n" +
                        "Discount: %d%%%n" +
                        "Discount Amount: $%s%n" +
                        "Final Charge: $%s%n",
                        toolCode,
                        toolType,
                        toolBrand,
                        rentalDays,
                        formatter.format(checkOut),
                        formatter.format(dueDate),
                        new DecimalFormat("#0.##").format(dailyCharge),
                        chargeDays,
                        new DecimalFormat("#0.##").format(preDiscountCharge),
                        discount,
                        new DecimalFormat("#0.##").format(discountAmount),
                        new DecimalFormat("#0.##").format(finalCharge)
                ));
    }
}
