import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    /**
     * Constructor.
     */
    public Account() {

    }

    /**
     * Constructor.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    /**
     * Dowithdraw.
     */
    public void doWithdrawing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (amount > this.balance) {
            throw new InsufficientFundsException(amount);
        }
        this.balance -= amount;
    }

    /**
     * Dodeposit.
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }
        this.balance += amount;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /**
     * Get transaction history.
     */
    public String getTransactionHistory() {
        String transactionHistory = "Lịch sử giao dịch của tài khoản " + accountNumber + ":";
        for (Transaction transaction : transactionList) {
            transactionHistory += "\n- " + transaction.getTransactionSummary();
        }
        return transactionHistory;
    }

    /**
     * Add.
     */
    public void addTransaction(Transaction newTransaction) {
        transactionList.add(newTransaction);
    }

    /**
     * Equals.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account other = (Account) obj;
            if (this.accountNumber == other.accountNumber) {
                return true;
            }
        }
        return false;
    }
}

