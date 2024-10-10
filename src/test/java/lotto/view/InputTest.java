package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThatThrownBy(()->input.validatePurchase("천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액 입력값이 1000원 미만이면 예외가 발생한다.")
    void inputMinRangeError(){
        assertThatThrownBy(()->input.validatePurchase("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액 입력값이 10만원 초과이면 예외가 발생한다.")
    void inputMaxRangeError(){
        assertThatThrownBy(()->input.validatePurchase("100001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("금액 입력값이 1000원 단위가 아니면 예외가 발생한다.")
    void inputDefaultValueError(){
        assertThatThrownBy(()->input.validatePurchase("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력된 당첨 번호를 쉼표로 구분했을 때 6개가 아니면 예외가 발생한다.")
    void inputWinningNumberCountError(){
        assertThatThrownBy(()->input.validateWinningNumber("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"일,이,삼,사,오,6", ".,2,3,4,5,6", "a,2,3,4,5,6"})
    @DisplayName("입력받은 당첨 번호에 쉼표와 숫자 이외의 입력이 있으면 예외가 발생한다.")
    void inputWinningNumberFormatError(String value){
        assertThatThrownBy(()->input.validateWinningNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,6","35,36,37,38,39,46"})
    @DisplayName("입력받은 당첨 번호중 하나라도 1에서 45사이가 아니면 예외가 발생한다.")
    void inputWinningNumberRangeError(String value){
        assertThatThrownBy(()->input.validateWinningNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력된 당첨 번호에 중복이 있으면 예외가 발생한다.")
    void inputWinningNumberDuplicateError(){
        assertThatThrownBy(()->input.validateWinningNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {",","a","일"})
    @DisplayName("보너스 번호 입력값이 숫자가 아니면 예외가 발생한다.")
    void inputBonusNumberFormatError(String value){
        assertThatThrownBy(()->input.validateBonusNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}