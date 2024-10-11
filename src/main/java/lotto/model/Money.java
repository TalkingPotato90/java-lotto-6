package lotto.model;

import lotto.util.Guide;
import lotto.util.Limit;

public class Money {
    private final int amount;

    public Money(String money) {
        validatePurchase(money);
        this.amount = calculateLottoQuantity(money);
    }

    private int calculateLottoQuantity(String money) {
        return Integer.parseInt(money) / Limit.PRICE_MIN.getValue();
    }

    public int getAmount() {
        return amount;
    }

    public boolean isCorrectPurchase(int lottoQuantity) {
        return amount == lottoQuantity;
    }

    private void validatePurchase(String input) {
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
}
