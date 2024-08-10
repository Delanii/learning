public class Main {

    public static void main(String[] args){

        // Read data from the Students table from a database

        for (int i = 1; i <= 5; i++) {

            Student student = new Student(String.valueOf(i),
                    "John " + String.valueOf(i),
                    "01012020",
                    "Math, Chemistry");

            System.out.println(student);
        }

        for (int i = 1; i <= 5; i++) {

            LPAStudent lpastudent = new LPAStudent(String.valueOf(i*6),
                    "Anders " + String.valueOf(i),
                    "01012020",
                    "Math, Chemistry");

            System.out.println(lpastudent);
        }

        Student jim = new Student(
                "8",
                "Jim",
                "05031996",
                "Math"
        );
        LPAStudent tim = new LPAStudent(
                "9",
                "Tim",
                "15081997",
                "Physical"
        );

        jim.setClassList(jim.getClassList() + ", Technology");
        // tim.setClassList(tim.classList() + ", Technology"); // error, cant change record data

        System.out.println(jim.getName());
        System.out.println(tim.name());
    }
}
