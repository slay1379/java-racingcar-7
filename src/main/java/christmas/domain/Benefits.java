package christmas.domain;

public class Benefits {
    public int dDayDiscount;
    public int weekdaysDiscount;
    public int weekendDiscount;
    public int specialDiscount;
    public int giftDiscount;
    public int totalAmount;
    public BadgeType type;

    public Benefits() {
        this.dDayDiscount = 0;
        this.weekdaysDiscount = 0;
        this.weekendDiscount = 0;
        this.specialDiscount = 0;
        this.giftDiscount = 0;
        this.totalAmount = 0;
        this.type = null;
    }
}
