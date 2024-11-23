package christmas.view;

import christmas.domain.Benefits;
import christmas.domain.OrderMenu;
import java.util.List;

public class OutputView {
    private static final String WELCOME_MSG = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ORDER_MENUS = "<주문 메뉴>";
    private static final String TOTAL_PRICE_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String GIFT_MENU = "<증정 메뉴>";
    private static final String BENEFIT_DETAILS = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>";
    private static final String TOTAL_PRICE_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE = "<12월 이벤트 배지>";
    private static final String CHRISTMAS_DDAY_DISCOUNT = "크리스마스 디데이 할인: -";
    private static final String WEEKDAYS_DISCOUNT = "평일 할인: -";
    private static final String SPECIAL_DISCOUNT = "특별 할인: -";
    private static final String GIFT_EVENT = "증정 이벤트: -";
    private static final String NOTHING = "없음";



    public void printWelcomeMsg() {
        System.out.println(WELCOME_MSG);
    }

    public void printOrderMenus(List<OrderMenu> orderMenus) {
        System.out.println(ORDER_MENUS);
        for (OrderMenu orderMenu : orderMenus) {
            System.out.println(orderMenu.name+" "+orderMenu.quantity+"개");
        }
    }

    public void printTotalPriceBeforeDiscount(int totalPriceBeforeDiscount) {
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT);
        System.out.println(totalPriceBeforeDiscount+"원");
    }

    public void printGiftMenu(boolean isGift) {
        System.out.println(GIFT_MENU);
        if (isGift) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println(NOTHING);
    }

    public void printBenefitDetails(Benefits benefits) {
        int total = benefits.dDayDiscount + benefits.weekdaysDiscount + benefits.specialDiscount + benefits.giftDiscount;
        if (total == 0) {
            System.out.println(NOTHING);
        }
        System.out.println(BENEFIT_DETAILS);
        if (benefits.dDayDiscount > 0) {
            System.out.println(CHRISTMAS_DDAY_DISCOUNT + benefits.dDayDiscount + 원);
        }
        if (benefits.weekdaysDiscount > 0) {
            System.out.println(WEEKDAYS_DISCOUNT + benefits.weekdaysDiscount + "원");
        }
        if (benefits.specialDiscount > 0) {
            System.out.println(SPECIAL_DISCOUNT + benefits.specialDiscount + "원");
        }
        if (benefits.giftDiscount > 0) {
            System.out.println(GIFT_EVENT + benefits.giftDiscount + "원");
        }
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT);
        System.out.println(-totalBenefitAmount + "원");
    }

    public void printTotalPriceAfterDiscount(int totalPriceAfterDiscount) {
        System.out.println(TOTAL_PRICE_AFTER_DISCOUNT);
        System.out.println(totalPriceAfterDiscount + "원");
    }
}

