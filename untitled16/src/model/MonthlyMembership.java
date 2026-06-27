package model;

public class MonthlyMembership extends Membership {

    public MonthlyMembership() {
        super();
        endDate = startDate.plusMonths(1);
        price = 800;
    }

    @Override
    public int getDuration() {
        return 30;
    }

    @Override
    public String toString() {
        return "Місячний абонемент | " + super.toString();
    }
}