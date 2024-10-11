package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public List<Integer> convertWinningNumber(String input){
        return Arrays.stream
                        (input
                                .replaceAll(" ","")
                                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int convertDigit(String input){
        return Integer.parseInt(input);
    }
    
}
