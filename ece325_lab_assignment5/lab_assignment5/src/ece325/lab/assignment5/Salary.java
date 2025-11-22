package ece325.lab.assignment5;

public class Salary {

    public static Double pay(Double salary, Double snacksAmount, Integer bonus) {

        // NULL checks
        if (salary == null) {
            throw new IllegalArgumentException("Salary cannot be null.");
        }
        if (snacksAmount == null) {
            throw new IllegalArgumentException("Snacks amount cannot be null.");
        }
        if (bonus == null) {
            throw new IllegalArgumentException("Bonus cannot be null.");
        }

        // Range checks
        if (salary < 0 || salary > 1000) {
            throw new IllegalArgumentException("Salary must be between 0 and 1000.");
        }
        if (snacksAmount < 0) {
            throw new IllegalArgumentException("Snacks amount cannot be negative.");
        }
        if (snacksAmount > salary) {
            throw new IllegalArgumentException("Snacks amount cannot exceed salary.");
        }
        if (bonus < 0 || bonus > 10) {
            throw new IllegalArgumentException("Bonus must be between 0 and 10 percent.");
        }

        // Compute base pay first
        double base = salary - snacksAmount;

        // Bonus computation
        double total = base + (base * bonus / 100.0);

        return total;
    }
}
