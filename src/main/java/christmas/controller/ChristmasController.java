package christmas.controller;

import christmas.domain.Benefits;
import christmas.domain.OrderMenu;
import christmas.service.BenefitService;
import christmas.service.OrderMenuService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {

    private InputView inputView;
    private OutputView outputView;
    private BenefitService benefitService;
    private OrderMenuService orderMenuService;
    private Benefits benefits;

    public ChristmasController(InputView inputView, OutputView outputView, BenefitService benefitService,
                               OrderMenuService orderMenuService, Benefits benefits) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.benefitService = benefitService;
        this.orderMenuService = orderMenuService;
        this.benefits = benefits;
    }

    public void run() {
        int day = visitDay();
        List<OrderMenu> orderMenus = order(day);
        processOrder(orderMenus,day);
    }

    private int visitDay() {
        outputView.printWelcomeMsg();
        return inputView.readVisitDay();
    }

    private List<OrderMenu> order(int day) {
        List<OrderMenu> orderMenus = inputView.readOrderMenu();
        outputView.printPreviewEventBenefits(day);
        return orderMenus;
    }

    private void processOrder(List<OrderMenu> orderMenus,int day) {
        int totalPrice = orderMenuService.calculateTotalPrice(orderMenus);
        outputView.printOrderMenus(orderMenus);
        outputView.printTotalPriceBeforeDiscount(totalPrice);
        if (orderMenuService.isApplicableEvent(orderMenus)) {
            benefitService.calculateTotalDiscount(totalPrice,day,orderMenus);
        }
        outputView.printGiftMenu(benefits.giftDiscount);
        outputView.printBenefitDetails(benefits);
        outputView.printTotalBenefitAmount(benefits.totalAmount);
        outputView.printTotalPriceAfterDiscount(totalPrice-(benefits.totalAmount- benefits.giftDiscount));
        outputView.printEventBadge(benefits);
    }
}
