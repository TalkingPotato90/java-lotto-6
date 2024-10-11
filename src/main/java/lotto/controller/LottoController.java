package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public List<Integer> convertData(String input){
        return Arrays.stream
                        (input
                                .replaceAll(" ","")
                                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
