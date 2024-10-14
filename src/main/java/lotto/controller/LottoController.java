package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.util.CommonIO;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private InputController inputController;
    private LottoGenerator lottoGenerator;
    private CommonIO io;

    public LottoController() {
        this.inputController = new InputController();
        this.lottoGenerator = new LottoGenerator();
        this.io = new CommonIO();
    }

    public int calculateAmount(){
        return new Money(inputController.convertDigit(inputController.createInput())).getAmount();
    }

    public void purchaseLottos(int amount){
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(lottoGenerator.execute());
            io.printGuide(lottos.get(i).getNumbers().toString());
        }
    }

}
