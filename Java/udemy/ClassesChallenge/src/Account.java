public class Account {

    private int accountNumber = 0;
    private double accountBalance = 0.0;
    private String customerName = "";
    private String email = "";
    private String phoneNumber = "";

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void withdraw(double amount) {

        if (this.accountBalance - amount < 0) {
            System.out.println("You can't withdraw more than your current account balance.");
        } else {
            setAccountBalance(this.accountBalance - amount);
        }

        this.showBalance();
    }

    public void deposit(double amount) {
        setAccountBalance(this.accountBalance + amount);
        this.showBalance();
    }

    public void showBalance(){
        System.out.println("Your current account balance is: $" + getAccountBalance());
    }
}
