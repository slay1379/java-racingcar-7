package christmas.domain;

public enum BadgeType {
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    final private String name;

    BadgeType(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
