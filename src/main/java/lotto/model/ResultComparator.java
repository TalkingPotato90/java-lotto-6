package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class ResultComparator {
    public int compareResults(List<Integer> userNumbers, List<Integer> winningNumbers) {
        List<Integer> copyOfUserNumbers = new ArrayList<>(userNumbers);
        copyOfUserNumbers.retainAll(winningNumbers);

        return copyOfUserNumbers.size();
    }

    public boolean isBonusMatch(List<Integer> userNumbers, int bonusNumber) {
        return userNumbers.contains(bonusNumber);
    }
}
