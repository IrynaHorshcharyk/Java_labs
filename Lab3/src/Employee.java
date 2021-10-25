import java.util.Comparator;

public class Employee {
    protected String surname;
    protected String position;
    protected int year;
    protected int salary;
    public Employee(String line) {
        String[] split = line.split(",");
        surname =split[0];
        position = split[1];
        year = Integer.parseInt(split[2]);
        salary = Integer.parseInt(split[3]);
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public int getYear() {
        return year;
    }
    @Override
    public String toString() {
        return "Employee { " +
                "surname='" + surname  +
                ", position=" + position +
                ", year=" + year +
                ", salary=" + salary +
                " }";
    }
}
