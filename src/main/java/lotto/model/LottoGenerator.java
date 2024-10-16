package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Limit;

import java.util.List;

public class LottoGenerator {
    public Lotto execute() {
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(Limit.RANDOM_MIN.getValue(),
                        Limit.RANDOM_MAX.getValue(), Limit.NUMBER_LENGTH.getValue());
        return new Lotto(numbers);
    }
}
