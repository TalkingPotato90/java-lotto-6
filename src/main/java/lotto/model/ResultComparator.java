package lotto.model;

import java.util.List;

public class ResultComparator {
    public int compareResults(List<Integer> userNumbers, WinningNumber winningNumber) {
        return winningNumber.checkWinningNumberMatchCount(userNumbers);
    }

    public boolean isBonusMatch(List<Integer> userNumbers, WinningNumber winningNumber) {
        return winningNumber.isBonusNumberMatch(userNumbers);
    }
}
