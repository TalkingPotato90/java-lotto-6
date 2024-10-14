package lotto.controller;

import lotto.model.*;
import lotto.util.CommonIO;
import lotto.util.Rank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private InputController inputController;
    private LottoGenerator lottoGenerator;
    private CommonIO io;
    private ResultComparator resultComparator;

    public LottoController() {
        this.inputController = new InputController();
        this.lottoGenerator = new LottoGenerator();
        this.io = new CommonIO();
        this.resultComparator = new ResultComparator();
    }

    public int calculateAmount() {
        return new Money(inputController.convertDigit(inputController.createInput())).getAmount();
    }

    public List<Lotto> purchaseLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(lottoGenerator.execute());
            io.printGuide(lottos.get(i).getNumbers().toString());
        }

        return lottos;
    }

    public double calculateTotalPrize(LottoResult lottoResult) {
        return lottoResult.getUserNumbers().stream()
                .mapToInt(userNumber -> calculateRank(userNumber, lottoResult.getWinningNumber())
                        .getWinningMoney()).sum();
    }

    public List<Rank> createWinningCount(LottoResult lottoResult) {
        return lottoResult.getUserNumbers().stream()
                .map(userNumber -> calculateRank(userNumber, lottoResult.getWinningNumber()))
                .collect(Collectors.toList());
    }

    private Rank calculateRank(Lotto userNumber, WinningNumber winningNumber) {
        int count = resultComparator.compareResults(userNumber, winningNumber);
        boolean isBonusMatch = resultComparator.isBonusMatch(userNumber, winningNumber);
        return Rank.valueOf(count, isBonusMatch);
    }

    public double calculateProfit(int amount, double totalPrize) {
        double money = amount * 1000;
        double profit = totalPrize / money * 100;

        DecimalFormat df = new DecimalFormat("#.#");

        return Double.parseDouble(df.format(profit));
    }

}
