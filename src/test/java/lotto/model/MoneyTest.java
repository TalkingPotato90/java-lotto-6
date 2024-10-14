package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("금액 입력값이 1000원 미만이면 예외가 발생한다.")
    void inputMinRangeError(){
        assertThatThrownBy(()-> new Money(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액 입력값이 10만원 초과이면 예외가 발생한다.")
    void inputMaxRangeError(){
        assertThatThrownBy(()-> new Money(100001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액 입력값이 1000원 단위가 아니면 예외가 발생한다.")
    void inputDefaultValueError(){
        assertThatThrownBy(()-> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구매 금액에 맞는 수량인지 확인")
    void checkValidQuantity(){
        assertThat(new Money(5000).isCorrectPurchase(5)).isTrue();
    }
}