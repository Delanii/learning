public class Main {

    public static void main(String[] args){

        HourlyEmployee jimmy = new HourlyEmployee("jimmy",
                "01. 10. 1978",
                "05. 11. 1995",
                15.8
                );

        System.out.println(jimmy.getAge());
        System.out.println(jimmy.collectPay());
        System.out.println(jimmy);

        SalariedEmployee ernest = new SalariedEmployee("ernest",
                "05. 08. 1965",
                "10. 12. 1978",
                268.95);
        System.out.println(ernest);

        System.out.println(ernest.collectPay());
    }
}
