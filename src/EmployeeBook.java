import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {

    private final Map<String, Employee> employees;

    public EmployeeBook() {
        employees = new HashMap<>();
    }

    private String getKey(Employee employee) {
        return employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymicName();
    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
            employees.put(getKey(employee), employee);
        }
    }

    public void addEmployee(String surname,
                            String name,
                            String patronymicName,
                            float salary,
                            int department) {
        addEmployee(new Employee(surname, name, patronymicName, (int) salary, department));
    }

    public void removeEmployee(Employee employee) {
        employees.remove(getKey(employee));
    }

    public void removeEmployee(int id) {
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getId() == id) {
                key = entry.getKey();
                break;
            }
        }
        if (key != null) {
            employees.remove(key);
        }
    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary((float) newSalary);
        }
    }

    public void changeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setDepartment(newDepartment);
        }
    }

    public void printEmployeesByDepartment() {
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудник из отдела " + department + ":");
            for (Employee employee : employees.values()) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymicName());
                }
            }
        }
    }

    public void printEmployeesWithSalaryLassThan(double bound) {
        System.out.println("Сотрудник с ЗП меньшей, чем " + bound + ":");
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < bound) {
                System.out.printf("id: %d, ФИО: %s %s %s, ЗП: %.2f%n", employee.getId(), employee.getSurname(),
                        employee.getName(), employee.getPatronymicName(), employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryGreaterOrEqualThen(double bound) {
        System.out.println("Сотрудники с ЗП большей или равной, чем " + bound + ":");
        for (Employee employee : employees.values()) {
            if (employee.getSalary() >= bound) {
                System.out.printf("id: %d, ФИО: %s %s %s, ЗП: %.2f%n", employee.getId(), employee.getSurname(),
                        employee.getName(), employee.getPatronymicName(), employee.getSalary());
            }
        }
    }

    public void indexSalaries(double index) {
        for (Employee employee : employees.values()) {
            employee.setSalary((float) (employee.getSalary() + employee.getSalary() * index / 100));
        }
    }

    public void indexSalariesForDepartment(double index, int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                employee.setSalary((float) (employee.getSalary() + employee.getSalary() * index / 100));
            }
        }
    }

    public double averageSalary() {
        return employees.size() != 0 ? totalSalaries() / employees.size() : 0;
    }

    public double averageSalaryForDepartment(int department) {
        double totalSalaryForDepartment = 0;
        int count = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                totalSalaryForDepartment += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : totalSalaryForDepartment / count;
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        double minSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            float maxSalary = 0;
            if (employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMaxSalary() {
        double minSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            float maxSalary = 0;
            if (employee.getSalary() < maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public double totalSalariesForDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public void printFullNameEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymicName());
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public void printAllEmployeesFromDepartment(int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.printf("id: %d, ФИО: %s %s %s, ЗП: %.2f%n", employee.getId(), employee.getSurname(),
                        employee.getName(), employee.getPatronymicName(), employee.getSalary());
            }
        }
    }
}
