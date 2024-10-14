package lotto.model;

import java.util.List;

public class LottoResult {
    private List<Lotto> userNumbers;
    private WinningNumber winningNumber;

    public LottoResult(List<Lotto> userNumbers, WinningNumber winningNumber) {
        this.userNumbers = userNumbers;
        this.winningNumber = winningNumber;
    }

    public List<Lotto> getUserNumbers() {
        return userNumbers;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
