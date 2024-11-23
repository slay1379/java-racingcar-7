package christmas.view;

import christmas.domain.OrderMenu;
import java.util.List;

public class OutputView {
    private static final String WELCOME_MSG = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ORDER_MENUS = "<주문 메뉴>";
    private static final String TOTAL_PRICE_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String GIFT_MENU = "<증정 메뉴>";
    private static final String BENEFIT_DETAILS = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_PRICE = "<총혜택 금액>";
    private static final String TOTAL_PRICE_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE = "<12월 이벤트 배지>";


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
        System.out.println("없음");
    }
}
