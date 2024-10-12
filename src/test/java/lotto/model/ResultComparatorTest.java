package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 비교 테스트")
class ResultComparatorTest {
    private ResultComparator comparator;

    @BeforeEach
    void setUp() {
        comparator = new ResultComparator();
    }

    @Test
    @DisplayName("생성된 로또 번호와 당첨번호의 일치 수량 확인")
    void testCompareResults() {
        assertThat(comparator.compareResults(List.of(1, 2, 3, 4, 5, 6),List.of(1, 2, 3, 4, 5, 7)))
                .isEqualTo(5);
    }
}