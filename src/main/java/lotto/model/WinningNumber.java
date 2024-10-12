package lotto.model;

import lotto.controller.LottoController;
import lotto.util.Guide;
import lotto.util.Limit;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> WinningNumbers;
    private final int bonusNumber;

    // TODO: 파라미터와 메서드 수정하기
    public WinningNumber(List<Integer> winningNumbers, String bonusNumber) {
        validateWinningNumber(winningNumbers);
        this.WinningNumbers = new ArrayList<>(winningNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void validateWinningNumber(List<Integer> winningNumbers) {
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

    public void validateBonusNumber(String input) {
        if (!input.matches(Guide.ONLY_DIGIT.getMessage())){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }

        if (Integer.parseInt(input) < Limit.RANDOM_MIN.getValue() || Integer.parseInt(input) > Limit.RANDOM_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자만 입력 가능합니다.");
        }

        // TODO : 당첨번호를 입력 받으면 배열로 반환하는 기능 구현 필요
        LottoController lottoController = new LottoController();

        if (isDuplicate(lottoController.convertWinningNumber("1,2,3,4,5,6"),input)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean isDuplicate(List<Integer> winningNumber, String bonusNumber) {
        return winningNumber.contains(Integer.parseInt(bonusNumber));
    }
}
