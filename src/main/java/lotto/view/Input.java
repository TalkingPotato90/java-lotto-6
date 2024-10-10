package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getInput() {
        return Console.readLine();
    }

    public void validate(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력가능합니다.]");
        }
    }
}
