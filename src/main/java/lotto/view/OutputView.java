package lotto.view;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.util.CommonIO;
import lotto.util.Guide;

import java.util.List;


public class OutputView {
    private final CommonIO io = new CommonIO();
    private final LottoController controller = new LottoController();
    private final InputController inputController = new InputController();

    public int purchaseLotto(){
        io.printGuide(Guide.PURCHASE.getMessage());
        int amount = controller.calculateAmount();
        io.printNewLine();

        return amount;
    }

    public List<Lotto> printPurchasedLotto(int amount){
        io.printGuide(amount + Guide.BUY_RESULT.getMessage());
        List<Lotto> userNumbers = controller.purchaseLottos(amount);
        io.printNewLine();
        return userNumbers;
    }

    public WinningNumber createWinningInformation(){
        io.printGuide(Guide.REQUEST_WINNING_NUMBER.getMessage());

        List<Integer> winningNumbers = inputController.convertWinningNumber(inputController.createInput());

        io.printNewLine();
        io.printGuide(Guide.REQUEST_BONUS_NUMBER.getMessage());

        int bonusNumber = inputController.convertDigit(inputController.createInput());

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);

        io.printNewLine();

        return winningNumber;
    }

}
