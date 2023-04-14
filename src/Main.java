
public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        Employee ivan = new Employee("Петров", "Иван", "Александрович", 1, 25050);

        employeeBook.addEmployee("Петрова", "Иванка", "Александровна", 2, 26050);
        employeeBook.addEmployee(ivan);

        employeeBook.changeSalary(ivan, 45000);

        employeeBook.printEmployeesByDepartment();

        employeeBook.printAllEmployees();
        double totalSalaries = employeeBook.totalSalaries();
        System.out.printf("Сумма ЗП всех сотрудников за месяц: %.3f%n", totalSalaries);
        Employee employeeWithMinSalary = employeeBook.findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП: " + employeeWithMinSalary);
        Employee employeeWithMaxSalary = employeeBook.findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП: " + employeeWithMaxSalary);
        double averageSalary = employeeBook.averageSalary();
        System.out.printf("Средняя ЗП всех сотрудников за месяц: ", averageSalary);
        employeeBook.printFullNameEmployees();

        employeeBook.indexSalaries(10);
        System.out.println("После индексации");
        employeeBook.printAllEmployees();

        System.out.printf("Сотрудник с минимальной ЗП из %d отдела: %s%n", 1, employeeBook.findEmployeeWithMinSalaryFromDepartment(1));
        System.out.printf("Сотрудник с максимальной ЗП из %d отдела: %s%n", 1, employeeBook.findEmployeeWithMaxSalaryFromDepartment(2));
        System.out.printf("Сумма ЗП всех сотрудников за месяц из отдела %d: %.2f%n", 3, employeeBook.totalSalariesForDepartment(3));
        System.out.printf("Средняя ЗП всех сотрудников за месяц из отдела %d: %.3f%n", 4, employeeBook.averageSalaryForDepartment(4));

        employeeBook.indexSalariesForDepartment(5, 1);
        System.out.println("После индексации для отдела" + 1);
        employeeBook.printAllEmployeesFromDepartment(1);
        employeeBook.printEmployeesWithSalaryLassThan(55000);
        employeeBook.printEmployeesWithSalaryGreaterOrEqualThen(55000);
    }
}