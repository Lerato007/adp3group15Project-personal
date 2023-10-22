package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Consultant;
import za.ac.cput.domain.Payment;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentFactoryTest {

    // i. Object Equality Test
    @Test
    public void a_testCompareConsultant() {
        Payment payment = new Payment();
        Payment myPayment = PaymentFactory.createPayment("R7000", "1 July 2023");
        String paymentDetails = myPayment.getPaymentAmount().toString();
        assertEquals(paymentDetails, "R5000");
    }


    // ii. Object Identity Test
    @Test
    public void b_testObjectIdentity() {
        Payment payment = new Payment();
        Payment payment1 = PaymentFactory.createPayment("R5000", "16 July 2023");
        Payment payment2 =  payment1;
        Payment payment3 = PaymentFactory.createPayment("R23000", "5 August 2023");

        assertSame(payment1, payment3);
    }

    // iii. Animal build Failing TEST
    @Test
    public void c_test_fail(){
        Payment payment = PaymentFactory.createPayment("R200", "1 January 2023");
        assertNotNull(payment);
        System.out.println(payment.toString());

    }

    // iv. Timeout Test
    @Test
    void d_testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("Execution exceeded timout duration!");
        });
    }

    // v. Disabling Test
}