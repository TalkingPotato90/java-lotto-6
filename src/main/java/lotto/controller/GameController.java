package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumber;
import lotto.util.Rank;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class GameController {
    private OutputView outputView = new OutputView();
    private LottoController lottoController = new LottoController();

    public void runApplication() {
        outputView.printInitialMessage();
        int amount = lottoController.purchaseLotto();
        outputView.printNewLine();

        outputView.printPurchasedLotto();
        List<Lotto> userNumbers = lottoController.purchaseLottos(amount);
        outputView.printNewLine();

        outputView.printWinningNumberRequest();
        List<Integer> winningNumber = lottoController.createWinningNumbers();
        outputView.printNewLine();

        outputView.printBonusNumberRequest();
        WinningNumber fullWinningNumber = lottoController.createWinningInformation(winningNumber);
        outputView.printNewLine();

        LottoResult lottoResult = new LottoResult(userNumbers, fullWinningNumber);
        Map<Rank,Long> resultStatics = lottoController.calculateResultStatics(lottoResult);
        double totalPrize = lottoController.calculateTotalPrize(lottoResult);
        double profit = lottoController.calculateProfit(amount,totalPrize);
        outputView.printResultStatics(resultStatics, profit);
    }
}
