package lotto;

import lotto.util.Guide;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new Output();
        Input input = new Input();

        output.printGuide(Guide.PURCHASE.getMessage());
        input.getInput();
    }
}
