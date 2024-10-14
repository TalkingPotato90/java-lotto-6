package lotto.view;

import lotto.controller.LottoController;
import lotto.util.CommonIO;
import lotto.util.Guide;


public class OutputView {
    private final CommonIO io = new CommonIO();
    private final LottoController controller = new LottoController();

    public int purchaseLotto(){
        io.printGuide(Guide.PURCHASE.getMessage());
        int amount = controller.calculateAmount();
        io.printNewLine();

        return amount;
    }

}
