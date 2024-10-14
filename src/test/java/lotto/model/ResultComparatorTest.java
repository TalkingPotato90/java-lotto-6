package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 비교 테스트")
class ResultComparatorTest {
    private ResultComparator comparator;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        comparator = new ResultComparator();
        winningNumbers = List.of(7,11,12,21,26,35);
        bonusNumber = 20;
    }

    @Test
    @DisplayName("생성된 로또 번호와 당첨번호의 일치 수량 확인")
    void testCompareResults() {
        assertThat(comparator.compareResults(new Lotto(List.of(1, 2, 3, 4, 5, 6)),new WinningNumber(winningNumbers,bonusNumber)))
                .isEqualTo(0);

        assertThat(comparator.compareResults(new Lotto(List.of(7, 11, 3, 12, 5, 6)),new WinningNumber(winningNumbers,bonusNumber)))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 로또 번호와 보너스 번호의 일치 확인")
    void matchBonusNumber() {
        assertThat(comparator.isBonusMatch(new Lotto(List.of(1, 2, 3, 4, 5, 20)),new WinningNumber(winningNumbers,bonusNumber)))
                .isTrue();
        assertThat(comparator.isBonusMatch(new Lotto(List.of(1, 2, 3, 4, 5, 6)),new WinningNumber(winningNumbers,bonusNumber)))
                .isFalse();
    }
}