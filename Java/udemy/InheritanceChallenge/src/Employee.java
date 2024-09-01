public class Employee extends Worker {

    private long employeeId;
    private String hireDate;

    private static int employeeNo = 1;

    Employee (String name, String birthDate,
            String hiredDate){

        super(name, birthDate);
        this.employeeId = Employee.employeeNo++;
        this.hireDate = hiredDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}
