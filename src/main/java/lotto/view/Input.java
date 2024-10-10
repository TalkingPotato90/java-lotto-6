package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Guide;
import lotto.util.Limit;

public class Input {
    public String getInput() {
        return Console.readLine();
    }

    public void validatePurchase(String input) {
        if (!input.matches(Guide.ONLY_DIGIT.getMessage())) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력가능합니다.]");
        }

        if (Integer.parseInt(input) < Limit.PRICE_MIN.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }

        if (Integer.parseInt(input) > Limit.PRICE_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최대 10만원까지 입력 가능 합니다.");
        }

        if (Integer.parseInt(input) % Limit.PRICE_MIN.getValue() != Limit.ZERO.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력 가능합니다.");
        }
    }

    public void validateWinningNumber(String input) {
        String[] numbers = input.replaceAll(" ", "").split(",");
        if (numbers.length != Limit.NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

}
