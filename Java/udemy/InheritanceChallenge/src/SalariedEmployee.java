public class SalariedEmployee extends Employee{

    private double annualSalary;
    private boolean isRetired;

    SalariedEmployee (String name, String birthDate,
                      String hireDate,
                      double annualSalary){

        super(name, birthDate,
                hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double collectPay(){

        double paycheck = Math.floor(annualSalary / 51);
        double adjustedPay = (isRetired) ? paycheck * 0.9 : paycheck;
        return adjustedPay;
    }

    public void setRetired(boolean isRetired){
        this.isRetired = true;
    }

    public void retire(){

        terminate();
        setRetired(true);
    }

    public void retire(String endDate){

        terminate(endDate);
        setRetired(true);
    }
}
