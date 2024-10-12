package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputControllerTest {
    private InputController controller;

    @BeforeEach
    void setUp() {
        controller = new InputController();
    }

    @ParameterizedTest
    @ValueSource(strings = {"일,이,삼,사,오,6", ".,2,3,4,5,6", "a,2,3,4,5,6"})
    @DisplayName("입력받은 당첨 번호에 쉼표와 숫자 이외의 입력이 있으면 예외가 발생한다.")
    void inputWinningNumberFormatError(String value){
        assertThatThrownBy(()-> controller.convertWinningNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {",","a","일"})
    @DisplayName("보너스 번호 입력값이 숫자가 아니면 예외가 발생한다.")
    void inputBonusNumberFormatError(String value){
        assertThatThrownBy(()-> controller.convertDigit(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}