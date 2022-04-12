import java.text.DecimalFormat;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Constructor.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Get transaction type in string.
     */
    public String getTransactionTypeString(int type) {
        String typeString = "";
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                typeString = "Nạp tiền vãng lai";
                break;
            case TYPE_WITHDRAW_CHECKING:
                typeString = "Rút tiền vãng lai";
                break;
            case TYPE_DEPOSIT_SAVINGS:
                typeString = "Nạp tiền tiết kiệm";
                break;
            case TYPE_WITHDRAW_SAVINGS:
                typeString = "Rút tiền tiết kiệm";
                break;
            default:
                break;
        }
        return typeString;
    }

    /**
     * Get transaction summary.
     */
    public String getTransactionSummary() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "Kiểu giao dịch: " + getTransactionTypeString(this.type)
                + ". Số dư ban đầu: $" + df.format(this.initialBalance)
                + ". Số tiền: $" + df.format(this.amount)
                + ". Số dư cuối: $" + df.format(this.finalBalance) + ".";
    }
}
