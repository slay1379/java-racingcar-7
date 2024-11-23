package christmas.service;

import christmas.domain.BadgeType;
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
    private Menus menus = new Menus();

    public BenefitService(Benefits benefits) {
        this.benefits = benefits;
    }

    public void calculateTotalDiscount(int totalPrice,int day,List<OrderMenu> orderMenus) {
        calculateDDayDiscount(day);
        calculateWeekdaysDiscount(day,orderMenus);
        calculateWeekendDiscount(day,orderMenus);
        calculateSpecialDiscount(day);
        calculateGiftDiscount(totalPrice);
        benefits.totalAmount +=
                benefits.dDayDiscount + benefits.weekendDiscount + benefits.weekdaysDiscount + benefits.specialDiscount
                        + benefits.giftDiscount;
        calculateBadgeType();
    }

    public void calculateDDayDiscount(int day) {
        if (isPeriodChristmasDiscount(day)) {
            benefits.dDayDiscount += 900 + day * 100;
        }
    }

    public void calculateWeekdaysDiscount(int day,List<OrderMenu> orderMenus) {
        if (isWeeksday(day)) {
            for (OrderMenu orderMenu : orderMenus) {
                if (menus.findMenuTypeByName(orderMenu.name) == MenuType.DESSERT) {
                    benefits.weekdaysDiscount += DESSERT_DISCOUNT_AMOUNT * orderMenu.quantity;
                }
            }
        }
    }

    public void calculateWeekendDiscount(int day,List<OrderMenu> orderMenus) {
        if (!isWeeksday(day)) {
            for (OrderMenu orderMenu : orderMenus) {
                if (menus.findMenuTypeByName(orderMenu.name) == MenuType.MAIN) {
                    benefits.weekendDiscount += MAIN_DISCOUNT_AMOUNT * orderMenu.quantity;
                }
            }
        }
    }

    public void calculateSpecialDiscount(int day) {
        if (isStarDay(day)) {
            benefits.specialDiscount += 1000;
        }
    }

    public void calculateGiftDiscount(int totalPrice) {
        if (isGift(totalPrice)) {
            benefits.giftDiscount += 25000;
        }
    }

    private void calculateBadgeType() {
        if (benefits.totalAmount >= 20000) {
            benefits.type = BadgeType.SANTA;
            return;
        }
        if (benefits.totalAmount >= 10000) {
            benefits.type = BadgeType.TREE;
            return;
        }
        if (benefits.totalAmount >= 5000) {
            benefits.type = BadgeType.STAR;
        }
    }

    private boolean isPeriodChristmasDiscount(int day) {
        if (day > 25) {
            return false;
        }
        return true;
    }

    private boolean isWeeksday(int day) {
        if (day % 7 == 1 || day % 7 == 2) {
            return false;
        }
        return true;
    }

    private boolean isStarDay(int day) {
        if (day % 7 == 3 || day == 25) {
            return true;
        }
        return false;
    }

    public boolean isGift(int totalPrice) {
        if (totalPrice >= 120000) {
            return true;
        }
        return false;
    }

    public boolean isApplicableEvent() {
        if (benefits.totalAmount >= 10000) {
            return true;
        }
        return false;
    }
}
