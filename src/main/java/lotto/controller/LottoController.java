package lotto.controller;

public class LottoController {
    public String[] temp(String input){
        return input.replaceAll(" ", "").split(",");
    }
}
