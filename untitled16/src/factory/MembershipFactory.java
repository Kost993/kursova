package factory;

import model.*;

public class MembershipFactory {

    public static Membership createMembership(String type) {

        switch(type.toUpperCase()) {

            case "MONTHLY":
                return new MonthlyMembership();

            case "YEARLY":
                return new YearlyMembership();

            case "SINGLE":
                return new SingleVisitMembership();

            default:
                throw new IllegalArgumentException(
                        "Невідомий тип абонемента");
        }
    }
}