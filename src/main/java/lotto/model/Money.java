package lotto.model;

import lotto.util.Limit;

public class Money {
    private final int amount;

    public Money(int money) {
        validatePurchase(money);
        this.amount = calculateLottoQuantity(money);
    }

    private int calculateLottoQuantity(int money) {
        return money / Limit.PRICE_MIN.getValue();
    }

    public int getAmount() {
        return amount;
    }

    public boolean isCorrectPurchase(int lottoQuantity) {
        return amount == lottoQuantity;
    }

    private void validatePurchase(int input) {
        if (input < Limit.PRICE_MIN.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }

        if (input > Limit.PRICE_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최대 10만원까지 입력 가능 합니다.");
        }

        if (input % Limit.PRICE_MIN.getValue() != Limit.ZERO.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력 가능합니다.");
        }
    }
}
