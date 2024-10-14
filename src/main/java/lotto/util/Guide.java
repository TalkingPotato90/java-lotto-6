package lotto.util;

public enum Guide {
    PURCHASE("구입금액을 입력해 주세요."),
    ONLY_DIGIT("^[0-9]*$"),
    WINNING_NUMBER_FORMAT("^[0-9,\\s]*$"),
    BUY_RESULT("개를 구매했습니다."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATICS("당첨통계\n---"),
    COUNT("개"),
    MONEY_UNIT("원"),
    MATCH(" 일치"),
    BONUS_MATCH(", 보너스 볼"),
    BRACKET_OPEN(" ("),
    BRACKET_CLOSE(")"),
    DASH(" - "),
    PROFIT_FWD("총 수익률은 "),
    PROFIT_AFT("%입니다.");

    String message;

    private Guide(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
