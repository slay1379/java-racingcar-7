package christmas.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menus {
    HashMap<String, Menu> menus = new HashMap<>(){{
        put("양송이수프", new Menu("양송이수프", 6000, MenuType.APPETIZER));
        put("타파스", new Menu("타파스", 5500, MenuType.APPETIZER));
        put("시저샐러드", new Menu("시저샐러드", 8000, MenuType.APPETIZER));
        put("티본스테이크", new Menu("티본스테이크", 55000, MenuType.MAIN));
        put("바비큐립", new Menu("바비큐립", 54000, MenuType.MAIN));
        put("해산물파스타", new Menu("해산물파스타", 35000, MenuType.MAIN));
        put("크리스마스파스타", new Menu("크리스마스파스타", 25000, MenuType.MAIN));
        put("초코케이크", new Menu("초코케이크", 15000, MenuType.DESERT));
        put("아이스크림", new Menu("아이스크림", 5000, MenuType.DESERT));
        put("제로콜라", new Menu("제로콜라", 3000, MenuType.DRINK));
        put("레드와인", new Menu("레드와인", 60000, MenuType.DRINK));
        put("샴페인", new Menu("샴페인", 25000, MenuType.DRINK));
    }};
}
