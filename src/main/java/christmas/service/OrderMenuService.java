package christmas.service;

import christmas.domain.MenuType;
import christmas.domain.Menus;
import christmas.domain.OrderMenu;
import java.util.List;

public class OrderMenuService {

    public List<OrderMenu> orderMenus;
    public Menus menus = new Menus();

    public OrderMenuService(List<OrderMenu> orderMenus) {
        this.orderMenus = orderMenus;
    }

    public boolean isOverTwenty() {
        if (calculateOrderMenuTotalQuantity() > 20) {
            return false;
        }
        return true;
    }

    public boolean isOnlyDrink() {
        for (OrderMenu orderMenu : orderMenus) {
            if (menus.findMenuTypeByName(orderMenu.name) != MenuType.DRINK) {
                return false;
            }
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
