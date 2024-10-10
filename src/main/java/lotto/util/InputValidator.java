package lotto.util;

import lotto.controller.LottoController;

import java.util.Arrays;

public class InputValidator {
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

        // TODO : 당첨번호를 입력 받으면 배열로 반환하는 기능 구현 필요
        LottoController lottoController = new LottoController();

        if (isDuplicate(lottoController.temp("1,2,3,4,5,6"),input)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean isDuplicate(String[] winningNumber, String bonusNumber) {
        return Arrays.asList(winningNumber).contains(bonusNumber);
    }
}
