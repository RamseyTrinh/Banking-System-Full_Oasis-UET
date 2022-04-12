public class InsufficientFundsException extends BankException {
    /**
     * Constructor.
     */
    public InsufficientFundsException(String message) {
        super(message);
    }

    /**
     * Constructorss.
     */
    public InsufficientFundsException(double amount) {
        super("Số dư tài khoản không đủ $" + String.format("%.2f", amount)
                + " để thực hiện giao dịch");
    }
}
