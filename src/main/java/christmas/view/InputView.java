package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_VISIT_DAY_MSG = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public int readVisitDay() {
        System.out.println(INPUT_VISIT_DAY_MSG);
        return Integer.parseInt(Console.readLine());
    }


}
