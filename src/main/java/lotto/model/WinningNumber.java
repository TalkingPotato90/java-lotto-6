package lotto.model;

import lotto.util.Limit;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> WinningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumber(winningNumbers);
        this.WinningNumbers = new ArrayList<>(winningNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
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

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < Limit.RANDOM_MIN.getValue() || bonusNumber > Limit.RANDOM_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자만 입력 가능합니다.");
        }

        if (isDuplicate(WinningNumbers, bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean isDuplicate(List<Integer> winningNumber, int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }
}
