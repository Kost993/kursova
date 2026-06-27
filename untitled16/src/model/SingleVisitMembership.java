package model;

public class SingleVisitMembership extends Membership {

    public SingleVisitMembership() {
        super();
        endDate = startDate;
        price = 100;
    }

    @Override
    public int getDuration() {
        return 1;
    }

    @Override
    public String toString() {
        return "Разове відвідування | " + super.toString();
    }
}