package lotto;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.util.Guide;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new Output();
        Input input = new Input();
        LottoController lottoController = new LottoController();
        LottoGenerator generator = new LottoGenerator();

        output.printGuide(Guide.PURCHASE.getMessage());

        int amount = new Money(input.getInput()).getAmount();

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(generator.execute());
            System.out.println(lottos.get(i).getNumbers());
        }
    }
}
