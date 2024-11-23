package christmas;

import christmas.controller.ChristmasController;
import christmas.domain.Benefits;
import christmas.service.BenefitService;
import christmas.service.OrderMenuService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Benefits benefits = new Benefits();
        BenefitService benefitService = new BenefitService(benefits);
        OrderMenuService orderMenuService = new OrderMenuService();

        ChristmasController controller = new ChristmasController(inputView, outputView, benefitService,
                orderMenuService, benefits);

        controller.run();
    }
}
