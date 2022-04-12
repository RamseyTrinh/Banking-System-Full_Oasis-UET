public class SavingsAccount extends Account {
    /**
     * Constructor.
     */
    public SavingsAccount() {

    }

    /**
     * Constructor.
     */
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * method.
     */
    @Override
    public void withdraw(double amount) {
        try {
            if (amount > 1000) {
                throw new InvalidFundingAmountException(amount);
            }
            if (this.getBalance() < 5000) {
                throw new InsufficientFundsException(amount);
            }
            Transaction transaction = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount,
                    getBalance(), getBalance() - amount);
            super.doWithdrawing(amount);
            addTransaction(transaction);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method.
     */
    @Override
    public void deposit(double amount) {
        try {
            Transaction transaction = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount,
                    getBalance(), getBalance() + amount);
            super.doDepositing(amount);
            addTransaction(transaction);
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}
