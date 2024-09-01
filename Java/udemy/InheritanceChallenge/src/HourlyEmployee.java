public class HourlyEmployee extends Employee{

    private double hourlyPayRate;

    HourlyEmployee (String name, String birthDate,
                      String hireDate,
                      double hourlyPayRate){

        super(name, birthDate,
                hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate(){
        return this.hourlyPayRate;
    }

    public double getDoublePay(){
        return collectPay() * 2;
    }

    @Override
    public double collectPay() {
        return 40 * getHourlyPayRate();
    }
}
