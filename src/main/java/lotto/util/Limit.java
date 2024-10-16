package lotto.util;

public enum Limit {
    RANDOM_MIN(1),
    RANDOM_MAX(45),
    NUMBER_LENGTH(6),
    PRICE_MIN(1_000),
    PRICE_MAX(100_000),
    ZERO(0);


    int value;

    private Limit(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
