package lotto;

import lotto.controller.InputController;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.util.Guide;
import lotto.util.Rank;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new Output();
        Input input = new Input();
        InputController inputController = new InputController();
        LottoGenerator generator = new LottoGenerator();

        output.printGuide(Guide.PURCHASE.getMessage());

        int amount = new Money(input.getInput()).getAmount();
        System.out.println();

        System.out.println(amount + Guide.BUY_RESULT.getMessage());

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(generator.execute());
            System.out.println(lottos.get(i).getNumbers());
        }
        System.out.println();

        System.out.println(Guide.REQUEST_WINNING_NUMBER.getMessage());

        List<Integer> winningNumbers = inputController.convertWinningNumber(input.getInput());

        System.out.println(Guide.REQUEST_BONUS_NUMBER.getMessage());
        int bonusNumber = inputController.convertDigit(input.getInput());

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);

        System.out.println();
        System.out.println(Guide.STATICS.getMessage());

    }
}
