package lotto;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumber;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();

        int amount = outputView.purchaseLotto();
        List<Lotto> userNumbers = outputView.printPurchasedLotto(amount);
        WinningNumber winningNumber = outputView.createWinningInformation();

        LottoResult lottoResult = new LottoResult(userNumbers, winningNumber);

        outputView.printResultStatics(lottoResult, amount);

    }
}
