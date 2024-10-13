package lotto.model;

import lotto.controller.InputController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    private InputController inputController;

    @BeforeEach
    void setUp() {
        inputController = new InputController();
    }

    @Test
    @DisplayName("입력된 당첨 번호를 쉼표로 구분했을 때 6개가 아니면 예외가 발생한다.")
    void inputWinningNumberCountError(){
        assertThatThrownBy(()-> new WinningNumber(inputController.convertWinningNumber("1, 2, 3"),5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "46,45,44,43,42,41"})
    @DisplayName("입력받은 당첨 번호중 하나라도 1에서 45사이가 아니면 예외가 발생한다.")
    void inputWinningNumberRangeError(String value){
        assertThatThrownBy(()-> new WinningNumber(inputController.convertWinningNumber(value), 45))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력된 당첨 번호에 중복이 있으면 예외가 발생한다.")
    void inputWinningNumberDuplicateError(){
        assertThatThrownBy(()-> new WinningNumber(inputController.convertWinningNumber("1, 2, 3, 4, 5, 5"),45))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,46,100})
    @DisplayName("보너스 번호 입력값이 1에서 45사이가 아니면 예외가 발생한다.")
    void inputBonusNumberRangeError(int value){
        assertThatThrownBy(()-> new WinningNumber(List.of(1, 2, 3, 4, 5, 6),value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호가 입력된 당첨 번호와 중복되면 예외가 발생한다.")
    void inputBonusNumberDuplicateError(){
        assertThatThrownBy(()-> new WinningNumber(List.of(1, 2, 3, 4, 5, 6),6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}