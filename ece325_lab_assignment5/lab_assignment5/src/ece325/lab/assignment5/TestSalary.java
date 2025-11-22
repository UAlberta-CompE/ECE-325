package ece325.lab.assignment5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSalary {

    private static final double DELTA = 0.001;

    @Test
    public void testNormalCase() {
        assertEquals(55.0, Salary.pay(100.0, 50.0, 10), DELTA);
    }

    @Test
    public void testMaxSalaryMaxBonus() {
        assertEquals(1100.0, Salary.pay(1000.0, 0.0, 10), DELTA);
    }

    @Test
    public void testZeroBonus() {
        assertEquals(500.0, Salary.pay(500.0, 0.0, 0), DELTA);
    }

    @Test
    public void testSnacksEqualSalary() {
        assertEquals(0.0, Salary.pay(500.0, 500.0, 0), DELTA);
    }

    @Test
    public void testMixedValues() {
        assertEquals(210.0, Salary.pay(300.0, 100.0, 5), DELTA);
    }

    @Test
    public void testNullSalary() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(null, 50.0, 5));
    }

    @Test
    public void testNullSnacks() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(200.0, null, 3));
    }

    @Test
    public void testNullBonus() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(200.0, 50.0, null));
    }

    @Test
    public void testSalaryTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(1200.0, 50.0, 5));
    }

    @Test
    public void testNegativeSalary() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(-5.0, 0.0, 5));
    }

    @Test
    public void testNegativeSnacks() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(200.0, -1.0, 5));
    }

    @Test
    public void testSnacksMoreThanSalary() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(100.0, 150.0, 5));
    }

    @Test
    public void testNegativeBonus() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(200.0, 50.0, -1));
    }

    @Test
    public void testBonusTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> Salary.pay(200.0, 50.0, 11));
    }
}
