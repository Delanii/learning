public class Customer {

    private String name;
    private double creditLimit;
    private String email;

    public Customer(String name,
                    double creditLimit,
                    String email){

        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public Customer(){
        this("New customer", 10.0, "newcustomer@mybank.com");
    }

    public Customer(String name,
                    String email){
        this(name, 11.0, email);
    }

    public String getName() {
        return this.name;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

    public String getEmail() {
        return this.email;
    }
}
