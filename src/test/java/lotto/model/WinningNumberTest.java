package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @Test
    @DisplayName("입력된 당첨 번호를 쉼표로 구분했을 때 6개가 아니면 예외가 발생한다.")
    void inputWinningNumberCountError(){
        assertThatThrownBy(()-> new WinningNumber(List.of(1, 2, 3),"5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    private static Stream<List<Integer>> testNumberRange() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @ParameterizedTest
    @MethodSource("testNumberRange")
    @DisplayName("입력받은 당첨 번호중 하나라도 1에서 45사이가 아니면 예외가 발생한다.")
    void inputWinningNumberRangeError(List<Integer> value){
        assertThatThrownBy(()-> new WinningNumber(value, "45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력된 당첨 번호에 중복이 있으면 예외가 발생한다.")
    void inputWinningNumberDuplicateError(){
        assertThatThrownBy(()-> new WinningNumber(List.of(1, 2, 3, 4, 5, 5),"45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {",","a","일"})
    @DisplayName("보너스 번호 입력값이 숫자가 아니면 예외가 발생한다.")
    void inputBonusNumberFormatError(String value){
        assertThatThrownBy(()-> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","46","100"})
    @DisplayName("보너스 번호 입력값이 1에서 45사이가 아니면 예외가 발생한다.")
    void inputBonusNumberRangeError(String value){
        assertThatThrownBy(()-> new WinningNumber(List.of(1, 2, 3, 4, 5, 6),value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호가 입력된 당첨 번호와 중복되면 예외가 발생한다.")
    void inputBonusNumberDuplicateError(){
        assertThatThrownBy(()-> new WinningNumber(List.of(1, 2, 3, 4, 5, 6),"6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}