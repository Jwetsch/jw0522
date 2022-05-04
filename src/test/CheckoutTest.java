package test;

import main.Checkout;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    @Test
    void execute() {
        Checkout.Request request = new Checkout.Request() {
            @Override
            public String getToolCode() {
                return "CHNS";
            }

            @Override
            public Integer getDayCount() {
                return 1;
            }

            @Override
            public Integer getDiscount() {
                return 100;
            }

            @Override
            public LocalDate getCheckOut() {
                return LocalDate.of(2015, Month.SEPTEMBER, 3);
            }
        };

        Checkout.execute(request);

    }
}