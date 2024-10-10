package lotto.util;

public enum Guide {
    PURCHASE("구입금액을 입력해 주세요.");


    String message;

    private Guide(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
