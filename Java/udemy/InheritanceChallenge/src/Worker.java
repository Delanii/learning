import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Worker {

    private String name;
    private String birthDate;
    protected String endDate;

    private final String datePattern = "dd. MM. yyyy";

    Worker(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge(){

        int currentYear = LocalDate.now().getYear();
        int birthYear = LocalDate.parse(
                birthDate, DateTimeFormatter.ofPattern(datePattern))
                .getYear();
        return currentYear - birthYear;
    }

    public double collectPay(){
        return 10.0;
    }

    public void setEndDate(String date){
        this.endDate = date;
    }

    public void terminate(){
        this.setEndDate(LocalDate.now()
                        .format(DateTimeFormatter.ofPattern(datePattern)));
    }

    public void terminate(String endDate){
        this.setEndDate(endDate);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
