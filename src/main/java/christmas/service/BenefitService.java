package christmas.service;

import christmas.domain.Benefits;

public class BenefitService {

    private Benefits benefits;

    public BenefitService(Benefits benefits) {
        this.benefits = benefits;
    }

    public void calculateDDayDiscount(int day) {
        if (isPeriodChristmasDiscount(day)) {
            benefits.dDayDiscount = day * 100;
        }
    }

    private boolean isPeriodChristmasDiscount(int day) {
        if (day > 25) {
            return false;
        }
        return true;
    }
}
