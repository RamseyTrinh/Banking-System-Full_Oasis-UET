import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Read Text.
     */
    public void readCustomerList(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        Customer newCustomer = new Customer();
        Account account;
        try {
            while (reader.ready()) {
                line = reader.readLine();
                if (line.contains("CHECKING")) {
                    account = new CheckingAccount();
                    account.accountNumber = Long.parseLong(line.substring(0, 10));
                    account.balance = Double.parseDouble(line.substring(line.indexOf("CHECKING")
                            + 9, line.length()));

                    newCustomer.getAccountList().add(account);
                    if (!reader.ready()) {
                        customerList.add(newCustomer);
                    }
                } else if (line.contains("SAVING")) {
                    account = new SavingsAccount();

                    account.accountNumber = Long.parseLong(line.substring(0, 10));
                    account.balance = Double.parseDouble(line.substring(line.indexOf("SAVING")
                            + 7, line.length()));

                    newCustomer.getAccountList().add(account);
                    if (!reader.ready()) {
                        customerList.add(newCustomer);
                    }
                } else {
                    if (newCustomer.getFullName() != null && !newCustomer.getFullName().isEmpty()) {
                        customerList.add(newCustomer);
                    }
                    newCustomer = new Customer();
                    newCustomer.setIdNumber(Long.parseLong(line.substring(line.length()
                            - 9, line.length())));
                    newCustomer.setFullName(line.substring(0, line.length() - 9));
                    if (!reader.ready()) {
                        customerList.add(newCustomer);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sắp xếp theo tên.
     */
    public String getCustomersInfoByNameOrder() {
        customerList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer customer1, Customer customer2) {
                return customer1.getFullName().compareTo(customer2.getFullName());
            }
        });
        String list = "";
        for (int i = 0; i < customerList.size(); i++) {
            if (i == customerList.size() - 1) {
                list += customerList.get(i).getCustomerInfo();
            } else {
                list += customerList.get(i).getCustomerInfo() + "\n";
            }
        }
        return list;
    }

    /**
     * sắp xếp theo ID.
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer customer1, Customer customer2) {
                return customer1.getIdNumber() > customer2.getIdNumber() ? 1 : -1;
            }
        });
        String list = "";
        for (int i = 0; i < customerList.size(); i++) {
            if (i == customerList.size() - 1) {
                list += customerList.get(i).getCustomerInfo();
            } else {
                list += customerList.get(i).getCustomerInfo() + "\n";
            }
        }
        return list;
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }
}
