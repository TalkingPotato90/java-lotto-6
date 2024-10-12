package lotto.util;

public class InputValidator {
    public void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 없습니다.");
        }
    }
}
