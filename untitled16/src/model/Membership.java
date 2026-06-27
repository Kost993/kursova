package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Membership implements Serializable {

    protected LocalDate startDate;
    protected LocalDate endDate;
    protected double price;

    public Membership() {
        startDate = LocalDate.now();
    }

    public abstract int getDuration();

    public boolean isActive() {
        return LocalDate.now().isBefore(endDate.plusDays(1));
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Початок: " + startDate +
                ", Кінець: " + endDate +
                ", Ціна: " + price;
    }
}