package lotto.view;

import lotto.util.CommonIO;
import lotto.util.Guide;
import lotto.util.Rank;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class OutputView {
    private final CommonIO io = new CommonIO();

    public void printInitialMessage(){
        io.printGuide(Guide.PURCHASE.getMessage());
    }

    public void printNewLine(){
        io.printNewLine();
    }

    public void printPurchasedLotto(){
        io.printGuide(Guide.BUY_RESULT.getMessage());
    }

    public void printWinningNumberRequest(){
        io.printGuide(Guide.REQUEST_WINNING_NUMBER.getMessage());
    }

    public void printBonusNumberRequest(){
        io.printGuide(Guide.REQUEST_BONUS_NUMBER.getMessage());
    }

    public void printResultStatics(Map<Rank,Long> lottoResult, double finalProfit) {
        io.printGuide(Guide.STATICS.getMessage());

        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        NumberFormat formatter = NumberFormat.getNumberInstance();

        for (Rank rank : ranks) {
            io.printGuide(formatRankMessage(rank, lottoResult, formatter));
        }

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

}
