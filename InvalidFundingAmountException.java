public class InvalidFundingAmountException extends BankException {
    /**
     * Constructor.
     */
    public InvalidFundingAmountException(String message) {
        super(message);
    }

    /**
     * Constructorsss.
     */
    public InvalidFundingAmountException(double amount) {
        super("Số tiền không hợp lệ: $" + String.format("%.2f", amount));
    }
}
