package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("로또 발행 테스트")
class LottoGeneratorTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

}