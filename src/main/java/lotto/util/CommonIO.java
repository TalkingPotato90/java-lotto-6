package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class CommonIO {
    public String getInput() {
        String input = Console.readLine();
        validate(input);
        return input;
    }

    public void printGuide(String message){
        System.out.println(message);
    }

    public void printNewLine(){
        System.out.println();
    }

    private void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 없습니다.");
        }
    }
}
