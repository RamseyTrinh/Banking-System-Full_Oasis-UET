import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    /**
     * Constructor.
     */
    public Customer() {

    }

    /**
     * Constructor.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * Get customer info.
     */
    public String getCustomerInfo() {
        return "Số CMND: " + this.idNumber + ". Họ tên: " + this.fullName.trim() + ".";
    }

    /**
     * Add account.
     */
    public void addAccount(Account newAccount) {
        accountList.add(newAccount);
    }

    /**
     * Remove account.
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public long getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return this.accountList;
    }
}
