package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumber;
import lotto.util.CommonIO;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private OutputView outputView = new OutputView();

    public void runApplication() {
        int amount = outputView.purchaseLotto();

        List<Lotto> userNumbers = outputView.printPurchasedLotto(amount);
        WinningNumber winningNumber = outputView.createWinningInformation();

        LottoResult lottoResult = new LottoResult(userNumbers, winningNumber);

        outputView.printResultStatics(lottoResult, amount);
    }
}
