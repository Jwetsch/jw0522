package test;

import data.DataStore;
import data.Error;
import data.RentalAgreement;
import data.Response;
import main.Checkout;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    @BeforeAll
    static void setUp(){
        DataStore.initialize();
    }

    @Test
    void checkOut_Test1_ExpectError() {
        Checkout.Request test1 = new Checkout.Request() {
            @Override
            public String getToolCode() {
                return "JAKR";
            }

            @Override
            public Integer getDayCount() {
                return 5;
            }

            @Override
            public Integer getDiscount() {
                return 101;
            }

            @Override
            public LocalDate getCheckOut() {
                return LocalDate.of(2015, Month.SEPTEMBER, 3);
            }
        };

        Response response = Checkout.checkOut(test1);
        response.displayResponse();
        assertTrue(response instanceof Error);
    }

    @Test
    void checkOut_Test2_ExpectSuccess_358Charge() {
        BigDecimal expectedCharge = new BigDecimal("3.58");
        Checkout.Request test2 = new Checkout.Request() {
            @Override
            public String getToolCode() {
                return "LADW";
            }

            @Override
            public Integer getDayCount() {
                return 3;
            }

            @Override
            public Integer getDiscount() {
                return 10;
            }

            @Override
            public LocalDate getCheckOut() {
                return LocalDate.of(2020, Month.JULY, 2);
            }
        };

        Response response = Checkout.checkOut(test2);
        response.displayResponse();
        assertTrue(response instanceof RentalAgreement);
        assertEquals(0, expectedCharge.compareTo(((RentalAgreement) response).getFinalCharge()));
    }

    @Test
    void checkOut_Test3_ExpectSuccess_335Charge() {
        BigDecimal expectedCharge = new BigDecimal("3.35");
        Checkout.Request test3 = new Checkout.Request() {
            @Override
            public String getToolCode() {
                return "CHNS";
            }

            @Override
            public Integer getDayCount() {
                return 5;
            }

            @Override
            public Integer getDiscount() {
                return 25;
            }

            @Override
            public LocalDate getCheckOut() {
                return LocalDate.of(2015, Month.JULY, 2);
            }
        };

        Response response = Checkout.checkOut(test3);
        response.displayResponse();
        assertTrue(response instanceof RentalAgreement);
        assertEquals(0, expectedCharge.compareTo(((RentalAgreement) response).getFinalCharge()));
    }

    @Test
    void checkOut_Test4_ExpectSuccess_897Charge() {
        BigDecimal expectedCharge = new BigDecimal("8.97");
        Checkout.Request test4 = new Checkout.Request() {
            @Override
            public String getToolCode() {
                return "JAKD";
            }

            @Override
            public Integer getDayCount() {
                return 6;
            }

            @Override
            public Integer getDiscount() {
                return 0;
            }

            @Override
            public LocalDate getCheckOut() {
                return LocalDate.of(2015, Month.SEPTEMBER, 3);
            }
        };

        Response response = Checkout.checkOut(test4);
        response.displayResponse();
        assertTrue(response instanceof RentalAgreement);
        assertEquals(0, expectedCharge.compareTo(((RentalAgreement) response).getFinalCharge()));
    }

    @Test
    void checkOut_Test5_ExpectSuccess_1495Charge() {
        BigDecimal expectedCharge = new BigDecimal("14.95");
        Checkout.Request test5 = new Checkout.Request() {
            @Override
            public String getToolCode() {
                return "JAKR";
            }

            @Override
            public Integer getDayCount() {
                return 9;
            }

            @Override
            public Integer getDiscount() {
                return 0;
            }

            @Override
            public LocalDate getCheckOut() {
                return LocalDate.of(2015, Month.JULY, 2);
            }
        };

        Response response = Checkout.checkOut(test5);
        response.displayResponse();
        assertTrue(response instanceof RentalAgreement);
        assertEquals(0, expectedCharge.compareTo(((RentalAgreement) response).getFinalCharge()));
    }

    @Test
    void checkOut_Test6_ExpectSuccess_149Charge() {
        BigDecimal expectedCharge = new BigDecimal("1.49");
        Checkout.Request test6 = new Checkout.Request() {
            @Override
            public String getToolCode() {
                return "JAKR";
            }

            @Override
            public Integer getDayCount() {
                return 4;
            }

            @Override
            public Integer getDiscount() {
                return 50;
            }

            @Override
            public LocalDate getCheckOut() {
                return LocalDate.of(2020, Month.JULY, 2);
            }
        };

        Response response = Checkout.checkOut(test6);
        response.displayResponse();
        assertTrue(response instanceof RentalAgreement);
        assertEquals(0, expectedCharge.compareTo(((RentalAgreement) response).getFinalCharge()));
    }
}