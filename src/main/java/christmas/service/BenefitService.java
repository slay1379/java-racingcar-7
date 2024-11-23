package christmas.service;

import christmas.domain.Benefits;
import christmas.domain.OrderMenu;
import java.util.List;

public class BenefitService {

    private Benefits benefits;
    private List<OrderMenu> orderMenus;
    private int day;

    public BenefitService(Benefits benefits, List<OrderMenu> orderMenus, int day) {
        this.benefits = benefits;
        this.orderMenus = orderMenus;
        this.day = day;
    }

    public void calculateDDayDiscount() {
        if (isPeriodChristmasDiscount(day)) {
            benefits.dDayDiscount = day * 100;
        }
    }

    public void calculateWeekdaysDiscount() {

    }

    private boolean isPeriodChristmasDiscount() {
        if (day > 25) {
            return false;
        }
        return true;
    }

    private boolean isWeeksday() {
        if (day % 7 == 1 || day % 7 == 2) {
            return false;
        }
        return true;
    }
}
