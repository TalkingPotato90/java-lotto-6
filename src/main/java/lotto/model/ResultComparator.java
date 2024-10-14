package lotto.model;

public class ResultComparator {
    public int compareResults(Lotto userNumbers, WinningNumber winningNumber) {
        return winningNumber.checkWinningNumberMatchCount(userNumbers.getNumbers());
    }

    public boolean isBonusMatch(Lotto userNumbers, WinningNumber winningNumber) {
        return winningNumber.isBonusNumberMatch(userNumbers.getNumbers());
    }
}
