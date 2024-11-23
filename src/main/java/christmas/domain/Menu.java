package christmas.domain;

public class Menu {
    private String name;
    private int cost;
    private MenuType type;

    public Menu(String name, int cost, MenuType type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }
}
