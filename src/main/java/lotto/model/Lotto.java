package lotto.model;

import lotto.util.Limit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (numbers.size() != numbers.stream().distinct().toList().size()) {
            throw new IllegalArgumentException();
        }

        numbers.stream()
                .filter(number -> number < Limit.RANDOM_MIN.getValue() || number > Limit.RANDOM_MAX.getValue())
                .forEach(number -> {
            throw new IllegalArgumentException();
        });
    }

    // TODO: 추가 기능 구현
}
