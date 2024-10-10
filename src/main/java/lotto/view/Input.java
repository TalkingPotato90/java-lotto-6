package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Limit;

public class Input {
    public String getInput() {
        return Console.readLine();
    }

    public void validate(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력가능합니다.]");
        }

        if (Integer.parseInt(input) < Limit.PRICE_MIN.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }
    }
}
