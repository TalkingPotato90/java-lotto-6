package lotto.controller;

import lotto.model.Money;

public class LottoController {
    private InputController inputController;

    public LottoController() {
        this.inputController = new InputController();
    }

    public int calculateAmount(){
        return new Money(inputController.convertDigit(inputController.createInput())).getAmount();
    }

}
