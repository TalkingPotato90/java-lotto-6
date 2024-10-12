package lotto.util;

public enum Guide {
    PURCHASE("구입금액을 입력해 주세요."),
    ONLY_DIGIT("^[0-9]*$"),
    WINNING_NUMBER_FORMAT("^[0-9,\\s]*$"),
    BUY_RESULT("개를 구매했습니다."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATICS("당첨통계\n---");


    String message;

    private Guide(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
