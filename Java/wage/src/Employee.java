public class Employee {

    public int baseSalary = 0;
    public int hourlyRate = 0;

    public int calculateWage(int extraHours){ // it's not necessary to add the class fields as parameters, since they are always present in the classes code ...!
        return baseSalary + (extraHours * hourlyRate);
    }
}
