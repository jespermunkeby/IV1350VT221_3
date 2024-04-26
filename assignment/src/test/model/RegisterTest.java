package model;

import main.model.Register;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {
    @Test
    void depopsitToBalance() {
        float initAmount = 0;
        float newAmount = 5;
        Register r = new Register();

        r.depopsitToBalance(initAmount);
        assertEquals(initAmount, r.getBalance());

        r.depopsitToBalance(newAmount);
        assertEquals(newAmount+initAmount, r.getBalance());
    }
}