package lotto.controller;

import lotto.util.Guide;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public List<Integer> convertWinningNumber(String input){
        validateWinningNumberInput(input);
        return Arrays.stream
                        (input
                                .replaceAll(" ","")
                                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int convertDigit(String input){
        validateDigitInput(input);
        return Integer.parseInt(input);
    }

    private void validateDigitInput(String input){
        if (!input.matches(Guide.ONLY_DIGIT.getMessage())) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.]");
        }
    }

    private void validateWinningNumberInput(String input){
        if (!input.matches(Guide.WINNING_NUMBER_FORMAT.getMessage())) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자와 쉼표만 입력 가능합니다.");
        }
    }
}
