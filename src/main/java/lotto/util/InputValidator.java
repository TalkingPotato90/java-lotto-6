package lotto.util;

import java.util.Arrays;

public class InputValidator {
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
        if (!input.matches(Guide.WINNING_NUMBER_FORMAT.getMessage())) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자와 쉼표만 입력 가능합니다.");
        }

        String[] numbers = input.replaceAll(" ", "").split(",");
        if (numbers.length != Limit.NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        Arrays.stream(numbers)
                .filter(number -> Integer.parseInt(number) < Limit.RANDOM_MIN.getValue() || Integer.parseInt(number) > Limit.RANDOM_MAX.getValue())
                .forEach(number -> {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자만 입력 가능합니다.");
                });

        if(Arrays.stream(numbers).distinct().toArray().length != Limit.NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
        }
    }

    public void validateBonusNumber(String input) {
        if (!input.matches(Guide.ONLY_DIGIT.getMessage())){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }

        if (Integer.parseInt(input) < Limit.RANDOM_MIN.getValue() || Integer.parseInt(input) > Limit.RANDOM_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자만 입력 가능합니다.");
        }
    }
}
