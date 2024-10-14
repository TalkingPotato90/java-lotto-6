package lotto;

import lotto.controller.InputController;
import lotto.model.WinningNumber;
import lotto.util.Guide;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputController inputController = new InputController();

        int amount = outputView.purchaseLotto();
        outputView.printPurchasedLotto(amount);

        System.out.println(Guide.REQUEST_WINNING_NUMBER.getMessage());
        List<Integer> winningNumbers = inputController.convertWinningNumber(inputController.createInput());
        System.out.println();
        System.out.println(Guide.REQUEST_BONUS_NUMBER.getMessage());
        int bonusNumber = inputController.convertDigit(inputController.createInput());

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);


        System.out.println();
        System.out.println(Guide.STATICS.getMessage());

    }
}
