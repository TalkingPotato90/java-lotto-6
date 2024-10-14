package lotto.view;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningResult;
import lotto.model.WinningNumber;
import lotto.util.CommonIO;
import lotto.util.Guide;
import lotto.util.Rank;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class OutputView {
    private final CommonIO io = new CommonIO();
    private final LottoController lottoController = new LottoController();
    private final InputController inputController = new InputController();

    public int purchaseLotto(){
        io.printGuide(Guide.PURCHASE.getMessage());
        int amount = lottoController.calculateAmount();
        io.printNewLine();

        return amount;
    }

    public List<Lotto> printPurchasedLotto(int amount){
        io.printGuide(amount + Guide.BUY_RESULT.getMessage());
        List<Lotto> userNumbers = lottoController.purchaseLottos(amount);
        io.printNewLine();
        return userNumbers;
    }

    public WinningNumber createWinningInformation(){
        io.printGuide(Guide.REQUEST_WINNING_NUMBER.getMessage());

        List<Integer> winningNumbers = inputController.convertWinningNumber(inputController.createInput());

        io.printNewLine();
        io.printGuide(Guide.REQUEST_BONUS_NUMBER.getMessage());

        int bonusNumber = inputController.convertDigit(inputController.createInput());

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);

        io.printNewLine();

        return winningNumber;
    }

    public void printResultStatics(LottoResult lottoResult, int amount){
        io.printGuide(Guide.STATICS.getMessage());

        double totalPrize = lottoController.calculateTotalPrize(lottoResult);
        List<Rank> winningResult = lottoController.createWinningCount(lottoResult);
        double finalProfit = lottoController.calculateProfit(amount, totalPrize);

        Map<Rank,Long> lottoResults = new WinningResult(winningResult).getStatistics();

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
                        + lottoResults.getOrDefault(rank,0L)
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
                    + lottoResults.getOrDefault(rank, 0L)
                    + Guide.COUNT.getMessage());
        }


        System.out.println(Guide.PROFIT_FWD.getMessage()
                + finalProfit
                + Guide.PROFIT_AFT.getMessage());
    }

}
