package lotto.controller;

import lotto.util.Guide;
import lotto.util.CommonIO;
import lotto.util.Limit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputController {
    private CommonIO commonIO = new CommonIO();

    public List<Integer> convertWinningNumber(String input){
        validateWinningNumberInput(input);
        List<Integer> winningNumbers = Arrays.stream
                        (input
                                .replaceAll(" ","")
                                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinningNumber(winningNumbers);
        return winningNumbers;
    }

    public int convertDigit(String input){
        validateDigitInput(input);
        return Integer.parseInt(input);
    }

    public String createInput(){
        return commonIO.getInput();
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

    private void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Limit.NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        winningNumbers.stream()
                .filter(number -> number < Limit.RANDOM_MIN.getValue() || number > Limit.RANDOM_MAX.getValue())
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자만 입력 가능합니다.");
                });

        if(winningNumbers.stream().distinct().count() != Limit.NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
        }
    }
}
