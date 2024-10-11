package lotto;

import lotto.controller.LottoController;
import lotto.model.Money;
import lotto.util.Guide;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new Output();
        Input input = new Input();
        LottoController lottoController = new LottoController();

        output.printGuide(Guide.PURCHASE.getMessage());

        int amount = new Money(input.getInput()).getAmount();

        System.out.println(amount);
    }
}
