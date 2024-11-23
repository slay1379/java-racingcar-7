package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.OrderMenu;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_VISIT_DAY_MSG = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int readVisitDay() {
        System.out.println(INPUT_VISIT_DAY_MSG);
        return Integer.parseInt(Console.readLine());
    }

    public List<OrderMenu> readOrderMenu() {
        System.out.println(INPUT_ORDER_MENU);
        String[] orderMenus = splitOrderMenu(Console.readLine());
        return parseOrderMenus(orderMenus);
    }

    private String[] splitOrderMenu(String orderMenu) {
        return orderMenu.split(",");
    }

    private List<OrderMenu> parseOrderMenus(String[] orderMenus) {
        List<OrderMenu> orderMenuList = new ArrayList<>();
        for (String orderMenu : orderMenus) {
            String[] split = orderMenu.split("-");
            orderMenuList.add(new OrderMenu(split[0], Integer.parseInt(split[1])));
        }
        return orderMenuList;
    }
}
