public class Main {
    public static void main(String[] args) {

        var employee = new Employee(50_000, 20);
        Employee.showNumberOfEmployees();
        int wage = employee.calculateWage(10);

       System.out.println(wage);
    }

    public static int calculateWage(
            int baseSalary,
            int extraHours,
            int hourlyRate
    ){
        return baseSalary + (extraHours * hourlyRate);
    }
}