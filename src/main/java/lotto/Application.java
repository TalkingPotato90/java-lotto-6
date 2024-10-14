package lotto;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.ResultComparator;
import lotto.model.WinningNumber;
import lotto.util.Guide;
import lotto.util.Rank;
import lotto.view.OutputView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController();

        int amount = outputView.purchaseLotto();
        List<Lotto> userNumbers = outputView.printPurchasedLotto(amount);
        WinningNumber winningNumber = outputView.createWinningInformation();

        System.out.println(Guide.STATICS.getMessage());

        double totalPrize = lottoController.calculateTotalPrize(userNumbers, winningNumber);
        List<Rank> winningResult = lottoController.createWinningCount(userNumbers, winningNumber);
        double finalProfit = lottoController.calculateProfit(amount, totalPrize);

        Map<Rank,Long> lottoResult = new LottoResult(winningResult).getStatistics();

        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

        NumberFormat formatter = NumberFormat.getNumberInstance();

        for (Rank rank : ranks) {
            if (rank == Rank.SECOND) {
                System.out.println(rank.getCountOfMatch() + Guide.COUNT.getMessage()
                        + Guide.MATCH.getMessage()
                        + Guide.BONUS_MATCH.getMessage()
                        + Guide.MATCH.getMessage()
                        + Guide.BRACKET_OPEN.getMessage()
                        + formatter.format(rank.getWinningMoney())
                        + Guide.MONEY_UNIT.getMessage()
                        + Guide.BRACKET_CLOSE.getMessage()
                        + Guide.DASH.getMessage()
                        + lottoResult.getOrDefault(rank,0L)
                        + Guide.COUNT.getMessage());
                continue;
            }

            System.out.println(rank.getCountOfMatch() + Guide.COUNT.getMessage()
                    + Guide.MATCH.getMessage()
                    + Guide.BRACKET_OPEN.getMessage()
                    + rank.getWinningMoney()
                    + Guide.MONEY_UNIT.getMessage()
                    + Guide.BRACKET_CLOSE.getMessage()
                    + Guide.DASH.getMessage()
                    + lottoResult.getOrDefault(rank, 0L)
                    + Guide.COUNT.getMessage());
        }


        System.out.println(Guide.PROFIT_FWD.getMessage()
                + finalProfit
                + Guide.PROFIT_AFT.getMessage());

    }
}
