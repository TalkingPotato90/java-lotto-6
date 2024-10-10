package lotto.util;

public enum Limit {
    RANDOM_MIN(1),
    RANDOM_MAX(45),
    NUMBER_LENGTH(6)
    ;


    int value;

    private Limit(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
