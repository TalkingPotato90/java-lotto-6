package lotto.view;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumber;
import lotto.model.WinningResult;
import lotto.util.CommonIO;
import lotto.util.Guide;
import lotto.util.Rank;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class OutputView {
    private final CommonIO io = new CommonIO();
    private final LottoController lottoController = new LottoController();
    private final InputController inputController = new InputController();

    public int purchaseLotto() {
        io.printGuide(Guide.PURCHASE.getMessage());
        int amount = repeatUntilValid(lottoController::calculateAmount);
        io.printNewLine();

        return amount;
    }

    public List<Lotto> printPurchasedLotto(int amount) {
        io.printGuide(amount + Guide.BUY_RESULT.getMessage());
        List<Lotto> userNumbers = lottoController.purchaseLottos(amount);
        io.printNewLine();
        return userNumbers;
    }

    public WinningNumber createWinningInformation() {
        List<Integer> winningNumbers = createWinningNumbers();
        io.printGuide(Guide.REQUEST_BONUS_NUMBER.getMessage());

        WinningNumber winningNumber = repeatUntilValid(() -> {
            int bonusNumber = inputController.convertDigit(inputController.createInput());
            return new WinningNumber(winningNumbers, bonusNumber);
        });

        io.printNewLine();

        return winningNumber;
    }

    private List<Integer> createWinningNumbers() {
        io.printGuide(Guide.REQUEST_WINNING_NUMBER.getMessage());

        List<Integer> winningNumbers = repeatUntilValid(()
                -> inputController.convertWinningNumber(inputController.createInput()));

        io.printNewLine();

        return winningNumbers;
    }

    public void printResultStatics(LottoResult lottoResult, int amount) {
        io.printGuide(Guide.STATICS.getMessage());

        List<Rank> winningResult = lottoController.createWinningCount(lottoResult);

        Map<Rank, Long> lottoResults = new WinningResult(winningResult).getStatistics();

        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

        NumberFormat formatter = NumberFormat.getNumberInstance();

        for (Rank rank : ranks) {
            io.printGuide(formatRankMessage(rank, lottoResults, formatter));
        }

        printProfit(lottoResult,amount);
    }

    private void printProfit(LottoResult lottoResult, int amount){
        double totalPrize = lottoController.calculateTotalPrize(lottoResult);
        double finalProfit = lottoController.calculateProfit(amount, totalPrize);

        io.printGuide(Guide.PROFIT_FWD.getMessage()
                + finalProfit
                + Guide.PROFIT_AFT.getMessage());
    }

    private String formatRankMessage(Rank rank, Map<Rank, Long> lottoResults, NumberFormat formatter) {
        StringBuilder result = new StringBuilder();
        result.append(rank.getCountOfMatch())
                .append(Guide.COUNT.getMessage())
                .append(Guide.MATCH.getMessage());

        if (rank == Rank.SECOND) {
            result.append(Guide.BONUS_MATCH.getMessage())
                    .append(Guide.MATCH.getMessage());
        }

        result.append(Guide.BRACKET_OPEN.getMessage())
                .append(formatter.format(rank.getWinningMoney()))
                .append(Guide.MONEY_UNIT.getMessage())
                .append(Guide.BRACKET_CLOSE.getMessage())
                .append(Guide.DASH.getMessage())
                .append(lottoResults.getOrDefault(rank, 0L))
                .append(Guide.COUNT.getMessage());

        return result.toString();
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException illegalArgumentException) {
            io.printGuide(illegalArgumentException.getMessage());
            return repeatUntilValid(function);
        }
    }

}
