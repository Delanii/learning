public class Employee {

    private int baseSalary;
    private int hourlyRate;

    public Employee(int baseSalary,
                    int hourlyRate) { // class constructor doesn't have a return type
        setBaseSalary(baseSalary);   // If the field has a setter, use that to leverage the validation that is part of the setter
        setHourlyRate(hourlyRate);
    }

    private void setBaseSalary(int baseSalary){
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Salary has to be more than zero."); // throwing error terminates the program
        }
        this.baseSalary = baseSalary; // So this happens if the above is `false`
    }

    private int getBaseSalary(){
        return baseSalary;
    }

    private void setHourlyRate(int hourlyRate){
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate has to be more than zero."); // throwing error terminates the program
        }
        this.hourlyRate = hourlyRate; // So this happens if the above is `false`
    }

    private int getHourlyRate(){
        return hourlyRate;
    }

    public int calculateWage(int extraHours){ // it's not necessary to add the class fields as parameters, since they are always present in the classes code ...!
        return baseSalary + (extraHours * hourlyRate);
    }
}
