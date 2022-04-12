public class CheckingAccount extends Account {
    /**
     * Constructor.
     */
    public CheckingAccount() {

    }

    /**
     * Constructor.
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * method.
     */
    @Override
    public void withdraw(double amount) {
        try {
            Transaction transaction = new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, amount,
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
            Transaction transaction = new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, amount,
                    getBalance(), getBalance() + amount);
            super.doDepositing(amount);
            addTransaction(transaction);
        } catch (InvalidFundingAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}
