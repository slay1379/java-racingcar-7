package christmas.view;

import christmas.domain.OrderMenu;
import java.util.List;

public class OutputView {
    private static final String WELCOME_MSG = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ORDER_MENUS = "<주문 메뉴>";

    public void printWelcomeMsg() {
        System.out.println(WELCOME_MSG);
    }

    public void printOrderMenus(List<OrderMenu> orderMenus) {
        System.out.println(ORDER_MENUS);
        for (OrderMenu orderMenu : orderMenus) {
            System.out.println(orderMenu.name+" "+orderMenu.quantity+"개");
        }
    }
}
