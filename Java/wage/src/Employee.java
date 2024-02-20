public class Employee {

    private int baseSalary = 0;
    private int hourlyRate = 0;

    public void setBaseSalary(int baseSalary){
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Salary has to be more than zero."); // throwing error terminates the program
        }
        this.baseSalary = baseSalary; // So this happens if the above is `false`
    }

    public int getBaseSalary(){
        return baseSalary;
    }

    public void setHourlyRate(int hourlyRate){
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate has to be more than zero."); // throwing error terminates the program
        }
        this.hourlyRate = hourlyRate; // So this happens if the above is `false`
    }

    public int getHourlyRate(){
        return hourlyRate;
    }

    public int calculateWage(int extraHours){ // it's not necessary to add the class fields as parameters, since they are always present in the classes code ...!
        return baseSalary + (extraHours * hourlyRate);
    }
}
