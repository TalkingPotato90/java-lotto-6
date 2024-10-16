package lotto.model;

import lotto.util.CommonIO;
import lotto.util.Limit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
        Collections.sort(this.winningNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int checkWinningNumberMatchCount(List<Integer> userNumbers) {
        return Math.toIntExact(userNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public boolean isBonusNumberMatch(List<Integer> userNumbers) {
        return userNumbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }


    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < Limit.RANDOM_MIN.getValue() || bonusNumber > Limit.RANDOM_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자만 입력 가능합니다.");
        }

        if (isDuplicate(winningNumbers, bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicate(List<Integer> winningNumber, int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }

}
