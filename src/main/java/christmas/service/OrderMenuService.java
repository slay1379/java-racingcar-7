package christmas.service;

import christmas.domain.MenuType;
import christmas.domain.Menus;
import christmas.domain.OrderMenu;
import java.util.List;

public class OrderMenuService {
    public Menus menus = new Menus();

    public OrderMenuService() {
    }

    public boolean isOverTwenty(List<OrderMenu> orderMenus) {
        if (calculateOrderMenuTotalQuantity(orderMenus) > 20) {
            return false;
        }
        return true;
    }

    public boolean isOnlyDrink(List<OrderMenu> orderMenus) {
        for (OrderMenu orderMenu : orderMenus) {
            if (menus.findMenuTypeByName(orderMenu.name) != MenuType.DRINK) {
                return false;
            }
        }
        return true;
    }

    public int calculateTotalPrice(List<OrderMenu> orderMenus) {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderMenus) {
            totalPrice += menus.findMenuCostByName(orderMenu.name) * orderMenu.quantity;
        }
        return totalPrice;
    }

    public boolean isApplicableEvent(List<OrderMenu> orderMenus) {
        if (calculateTotalPrice(orderMenus) >= 10000) {
            return true;
        }
        return false;
    }

    private int calculateOrderMenuTotalQuantity(List<OrderMenu> orderMenus) {
        int total = 0;
        for (OrderMenu orderMenu : orderMenus) {
            total += orderMenu.quantity;
        }
        return total;
    }
}
