package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 발행 테스트")
class LottoGeneratorTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

//    @Test
//    @DisplayName("금액과 일치하는 수량을 구매하는지 확인")
//    void createLottoQuantityCheck() {
//        assertThat(lottoGenerator.purchase("1000")).isEqualsTo(1);
//    }
}