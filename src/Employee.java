public class Employee {
    private final String surname;
    private final String name;
    private final String patronymicName;
    private int department;
    private float salary;
    private static int counter;
    private final int id;

    public Employee(String surname, String name, String patronymicName, int department, float salary) {
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.department = department;
        this.salary = salary;
        id = ++counter;

    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("id: %d. | ФИО: %-15s %-15s %-15s | Зарплата: %-6.1f | Отдел: %-3d", id, surname, name, patronymicName, salary,department);
    }
}
