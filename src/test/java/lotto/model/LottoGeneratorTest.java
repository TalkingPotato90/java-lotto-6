package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 발행 테스트")
class LottoGeneratorTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("생성된 로또가 6자리가 맞는지 확인")
    void lottoLengthCheck(){
        assertThat(lottoGenerator.execute().getNumbers())
                .hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또가 숫자가 범위 내인지 확인")
    void lottoRangeCheck(){
        assertThat(lottoGenerator.execute().getNumbers())
                .allMatch(number -> number >= 1 && number <= 45);
    }



}