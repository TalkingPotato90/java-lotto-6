package lotto.util;

public enum Guide {
    PURCHASE("구입금액을 입력해 주세요."),
    ONLY_DIGIT("^[0-9]*$"),
    WINNING_NUMBER_FORMAT("^[0-9,\\s]*$");


    String message;

    private Guide(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
