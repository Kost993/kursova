package model;

public class YearlyMembership extends Membership {

    public YearlyMembership() {
        super();
        endDate = startDate.plusYears(1);
        price = 7000;
    }

    @Override
    public int getDuration() {
        return 365;
    }

    @Override
    public String toString() {
        return "Річний абонемент | " + super.toString();
    }
}