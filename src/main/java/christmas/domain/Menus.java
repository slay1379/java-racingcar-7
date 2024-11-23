package christmas.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  Menus {

    HashMap<String, Object> menu1 = new HashMap<String, Object>(){{
        put("name", "양송이스프");
        put("cost", 6000);
        put("type", MenuType.APPETIZER);
    }};
    HashMap<String, Object> menu2 = new HashMap<String, Object>(){{
        put("name", "타파스");
        put("cost", 5500);
        put("type", MenuType.APPETIZER);
    }};
    HashMap<String, Object> menu3 = new HashMap<String, Object>(){{
        put("name", "시저샐러드");
        put("cost", 8000);
        put("type", MenuType.APPETIZER);
    }};
    HashMap<String, Object> menu4 = new HashMap<String, Object>(){{
        put("name", "티본스테이크");
        put("cost", 55000);
        put("type", MenuType.MAIN);
    }};
    HashMap<String, Object> menu5 = new HashMap<String, Object>(){{
        put("name", "바비큐립");
        put("cost", 54000);
        put("type", MenuType.MAIN);
    }};
    HashMap<String, Object> menu6 = new HashMap<String, Object>(){{
        put("name", "해산물파스타");
        put("cost", 35000);
        put("type", MenuType.MAIN);
    }};
    HashMap<String, Object> menu7 = new HashMap<String, Object>(){{
        put("name", "크리스마스파스타");
        put("cost", 25000);
        put("type", MenuType.MAIN);
    }};
    HashMap<String, Object> menu8 = new HashMap<String, Object>(){{
        put("name", "초코케이크");
        put("cost", 15000);
        put("type", MenuType.DESSERT);
    }};
    HashMap<String, Object> menu9 = new HashMap<String, Object>(){{
        put("name", "아이스크림");
        put("cost", 5000);
        put("type", MenuType.DESSERT);
    }};
    HashMap<String, Object> menu10 = new HashMap<String, Object>(){{
        put("name", "제로콜라");
        put("cost", 3000);
        put("type", MenuType.DRINK);
    }};
    HashMap<String, Object> menu11 = new HashMap<String, Object>(){{
        put("name", "레드와인");
        put("cost", 60000);
        put("type", MenuType.DRINK);
    }};
    HashMap<String, Object> menu12 = new HashMap<String, Object>(){{
        put("name", "샴페인");
        put("cost", 25000);
        put("type", MenuType.DRINK);
    }};

    ArrayList<HashMap<String, Object>> menus = new ArrayList<HashMap<String, Object>>(){{
        add(menu1);
        add(menu2);
        add(menu3);
        add(menu4);
        add(menu5);
        add(menu6);
        add(menu7);
        add(menu8);
        add(menu9);
        add(menu10);
        add(menu11);
        add(menu12);
    }};

    public MenuType findMenuTypeByName(String menuName) {
        for (HashMap<String, Object> menu : menus) {
            if (menu.get("name").equals(menuName)) {
                return (MenuType) menu.get("type");
            }
        }
        return null;
    }

    public int findMenuCostByName(String menuName) {
        for (HashMap<String, Object> menu : menus) {
            if (menu.get("name").equals(menuName)) {
                return (int) menu.get("cost");
            }
        }
        return 0;
    }
}
