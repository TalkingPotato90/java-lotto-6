package lotto;

import lotto.controller.InputController;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.util.Guide;
import lotto.util.CommonIO;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputController inputController = new InputController();
        LottoGenerator generator = new LottoGenerator();

        int amount = outputView.purchaseLotto();


        System.out.println(amount + Guide.BUY_RESULT.getMessage());

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(generator.execute());
            System.out.println(lottos.get(i).getNumbers());
        }
        System.out.println();

        System.out.println(Guide.REQUEST_WINNING_NUMBER.getMessage());

        List<Integer> winningNumbers = inputController.convertWinningNumber(inputController.createInput());

        System.out.println(Guide.REQUEST_BONUS_NUMBER.getMessage());
        int bonusNumber = inputController.convertDigit(inputController.createInput());

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);


        System.out.println();
        System.out.println(Guide.STATICS.getMessage());

    }
}
