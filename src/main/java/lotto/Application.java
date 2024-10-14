package lotto;

import lotto.model.Lotto;
import lotto.model.ResultComparator;
import lotto.model.WinningNumber;
import lotto.util.Guide;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        ResultComparator resultComparator = new ResultComparator();

        int amount = outputView.purchaseLotto();
        List<Lotto> userNumbers = outputView.printPurchasedLotto(amount);
        WinningNumber winningNumber = outputView.createWinningInformation();

        System.out.println(Guide.STATICS.getMessage());

        userNumbers.forEach(userNumber -> {
            int count = resultComparator.compareResults(userNumber, winningNumber);

            if (count < 3) {
                System.out.println("꽝");
            }else if (count == 3) {
                System.out.println("5등");
            }else if (count == 4) {
                System.out.println("4등");
            }else if (count == 5) {
                boolean isSecondWin = resultComparator.isBonusMatch(userNumber, winningNumber);
                if (isSecondWin) {
                    System.out.println("2등");
                }else {
                    System.out.println("3등");
                }
            }else if (count == 6) {
                System.out.println("1등");
            }
        });

    }
}
