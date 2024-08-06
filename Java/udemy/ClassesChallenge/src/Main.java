public class Main {

    public static void main(String[] args) {

        Account myAccount = new Account();

        myAccount.showBalance();

        Account newAccount = new Account(
                12345,
                1000.0,
                "Tomas",
                "t.me@me.io",
                "+421568456"
        );

        newAccount.deposit(154000);

        newAccount.withdraw(200000);
        newAccount.withdraw(15000);

        Account anotherAccount = new Account("Myself",
                "me@myself.org",
                "+3995");

        anotherAccount.setAccountBalance(54.21);
        System.out.println(anotherAccount.getAccountNumber() + " " + anotherAccount.getAccountBalance());
    }
}
