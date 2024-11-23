package christmas.service;

import christmas.domain.Benefits;
import christmas.domain.MenuType;
import christmas.domain.Menus;
import christmas.domain.OrderMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitService {

    private static final int DESSERT_DISCOUNT_AMOUNT = 2023;
    private static final int MAIN_DISCOUNT_AMOUNT = 2023;

    private Benefits benefits;
    private List<OrderMenu> orderMenus;
    private int day;
    private Menus menus;

    public BenefitService(Benefits benefits, List<OrderMenu> orderMenus, int day, Menus menus) {
        this.benefits = benefits;
        this.orderMenus = orderMenus;
        this.day = day;
        this.menus = menus;
    }

    public void calculateDDayDiscount() {
        if (isPeriodChristmasDiscount()) {
            benefits.dDayDiscount = day * 100;
        }
    }

    public void calculateWeekdaysDiscount() {
        if (isWeeksday()) {
            for (OrderMenu orderMenu : orderMenus) {
                if (menus.findMenuTypeByName(orderMenu.name) == MenuType.DESSERT) {
                    benefits.weekdaysDiscount += DESSERT_DISCOUNT_AMOUNT;
                }
            }
        }
    }

    public void calculateWeekendDiscount() {
        if (!isWeeksday()) {
            for (OrderMenu orderMenu : orderMenus) {
                if (menus.findMenuTypeByName(orderMenu.name) == MenuType.MAIN) {
                    benefits.weekendDiscount += MAIN_DISCOUNT_AMOUNT;
                }
            }
        }
    }

    public void calculateSpecialDiscount() {
        if (isStarDay()) {
            benefits.specialDiscount += 1000;
        }
    }

    public boolean isGift() {

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

    private boolean isStarDay() {
        if (day % 7 == 3 || day == 25) {
            return true;
        }
        return false;
    }

    private boolean isGift(int totalPrice) {
        if (totalPrice >= 120000) {
            return true;
        }
        return false;
    }
}
