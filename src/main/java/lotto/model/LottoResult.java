package lotto.model;

import lotto.util.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private List<Rank> winningCount;

    public LottoResult(List<Rank> winningCount) {
        this.winningCount = winningCount;
    }

    public Map<Rank, Long> getStatistics() {
        return winningCount.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }

}
