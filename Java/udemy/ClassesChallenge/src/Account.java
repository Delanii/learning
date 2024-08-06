public class Account {

    private int accountNumber = 0;
    private double accountBalance = 0.0;
    private String customerName = "";
    private String email = "";
    private String phoneNumber = "";

    public Account(){

        this(11111,
                2.50,
                "New user",
                "account@default.com",
                "+4200");

        System.out.println("Empty constructor called.");
    }

    public Account(int accountNumber,
                   double accountBalance,
                   String customerName,
                   String email,
                   String phoneNumber){

        System.out.println("Called account constructor with parameters.");

        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Account(String customerName,
                   String email,
                   String phoneNumber) {
        this(9999, 5.55, customerName, email, phoneNumber);
    } // This constructor has a default value for the explicitly set fields -- the `accountNumber` and `accountBalance` have a default value.

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
