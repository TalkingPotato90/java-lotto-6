package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력값 검증")
class InputTest {

    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @Test
    @DisplayName("금액 입력값이 숫자가 아니면 예외가 발생한다.")
    void inputFormatError(){
        assertThatThrownBy(()->input.validate("천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액 입력값이 1000원 미만이면 예외가 발생한다.")
    void inputMinRangeError(){
        assertThatThrownBy(()->input.validate("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액 입력값이 10만원 초과이면 예외가 발생한다.")
    void inputMaxRangeError(){
        assertThatThrownBy(()->input.validate("100001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액 입력값이 1000원 단위가 아니면 예외가 발생한다.")
    void inputDefaultValueError(){
        assertThatThrownBy(()->input.validate("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}