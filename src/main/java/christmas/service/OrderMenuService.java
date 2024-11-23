package christmas.service;

import christmas.domain.OrderMenu;
import java.util.List;

public class OrderMenuService {

    public List<OrderMenu> orderMenus;

    public OrderMenuService(List<OrderMenu> orderMenus) {
        this.orderMenus = orderMenus;
    }

    public boolean isOverTwenty() {
        if (calculateOrderMenuTotalQuantity() > 20) {
            return false;
        }
        return true;
    }

    private int calculateOrderMenuTotalQuantity() {
        int total = 0;
        for (OrderMenu orderMenu : orderMenus) {
            total += orderMenu.quantity;
        }
        return total;
    }
}
